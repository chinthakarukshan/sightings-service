package com.nygen.au.sightings.service;

import com.nygen.au.sightings.common.exception.SightingNotFoundException;
import com.nygen.au.sightings.dto.SightingRequest;
import com.nygen.au.sightings.dto.SightingResponse;
import com.nygen.au.sightings.entity.Sighting;
import com.nygen.au.sightings.mapper.SightingMapper;
import com.nygen.au.sightings.repository.SightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SightingService {

    private final SightingRepository sightingRepository;
    private final SightingMapper sightingMapper;

    public SightingService(SightingRepository sightingRepository, SightingMapper sightingMapper) {
        this.sightingRepository = sightingRepository;
        this.sightingMapper = sightingMapper;
    }

    public SightingResponse findById(Long id) {
        Sighting sighting =  sightingRepository.findById(id).orElseThrow(() -> new SightingNotFoundException("Sighting not found for " + id)) ;
        return sightingMapper.toResponse(sighting);
    }

    public List<SightingResponse> findAll(String region){

        List<Sighting> sightings =  (region == null || region.isBlank())? sightingRepository.findAll(): sightingRepository.findByRegion(region);
        return sightings.stream().map(sightingMapper::toResponse).toList();

    }

    public ResponseEntity addSighting(SightingRequest sightingRequest) {
        sightingRepository.save(sightingMapper.toEntity(sightingRequest));
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
