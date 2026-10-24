package com.nygen.au.sightings.service;

import com.nygen.au.sightings.common.exception.SightingNotFoundException;
import com.nygen.au.sightings.entity.Sighting;
import com.nygen.au.sightings.repository.SightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SightingService {

    @Autowired
    private SightingRepository sightingRepository;

    public Sighting searchSightingbyId(Long id) throws SightingNotFoundException{

        Optional<Sighting> sighting = sightingRepository.findById(id);

        if (sighting.isEmpty()) throw new SightingNotFoundException("Sighting not found for " + id);

        return sighting.get();
    }

    public List<Sighting> findAll(String region){

        return (region == null || region.isBlank())? sightingRepository.findAll(): sightingRepository.findByRegion(region);

    }
}
