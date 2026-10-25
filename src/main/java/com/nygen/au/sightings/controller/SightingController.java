package com.nygen.au.sightings.controller;

import com.nygen.au.sightings.dto.SightingRequest;
import com.nygen.au.sightings.dto.SightingResponse;
import com.nygen.au.sightings.service.SightingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sightings")
public class SightingController {

    private final SightingService sightingService;

    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    @GetMapping
    public List<SightingResponse> getSightings(@RequestParam(required = false) String region) {
        return sightingService.findAll(region);
    }

    @GetMapping("/{id}")
    public SightingResponse getSighting(@PathVariable Long id) {
        return sightingService.findById(id);
    }

    @PutMapping("/{id}")
    public SightingResponse updateSighting(@PathVariable Long id,
                                           @Valid @RequestBody SightingRequest request) {
        return sightingService.updateSighting(id,request);
    }

    @PostMapping
    public ResponseEntity<SightingResponse> createSighting(@Valid @RequestBody SightingRequest sightingRequest) {
        SightingResponse sightingResponse = sightingService.addSighting(sightingRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sightingResponse.id())
                .toUri();
        return ResponseEntity.created(uri).body(sightingResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSighting(@PathVariable Long id) {
        sightingService.deleteSighting(id);
        return ResponseEntity.noContent().build();
    }
}
