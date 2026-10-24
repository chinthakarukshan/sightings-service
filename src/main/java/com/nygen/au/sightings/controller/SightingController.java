package com.nygen.au.sightings.controller;

import com.nygen.au.sightings.common.exception.SightingNotFoundException;
import com.nygen.au.sightings.entity.Sighting;
import com.nygen.au.sightings.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sightings")
public class SightingController {

    @Autowired
    private SightingService sightingService;

    @GetMapping
    public List<Sighting> getSightingbyRegion(@RequestParam(required = false) String region) {
        return sightingService.findAll(region);
    }
}
