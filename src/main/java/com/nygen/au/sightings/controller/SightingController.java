package com.nygen.au.sightings.controller;

import com.nygen.au.sightings.common.exception.SightingNotFoundException;
import com.nygen.au.sightings.dto.SightingRequest;
import com.nygen.au.sightings.dto.SightingResponse;
import com.nygen.au.sightings.entity.Sighting;
import com.nygen.au.sightings.service.SightingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sightings")
public class SightingController {

    private final SightingService sightingService;

    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping
    public List<SightingResponse> getSightingbyRegion(@RequestParam(required = false) String region) {
        return sightingService.findAll(region);
    }

    @PostMapping
    public ResponseEntity createSighting(@Valid @RequestBody SightingRequest sightingRequest) {
        return sightingService.addSighting(sightingRequest);
    }
}
