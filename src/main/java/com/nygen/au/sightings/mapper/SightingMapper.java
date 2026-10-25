package com.nygen.au.sightings.mapper;

import com.nygen.au.sightings.common.Status;
import com.nygen.au.sightings.dto.SightingRequest;
import com.nygen.au.sightings.dto.SightingResponse;
import com.nygen.au.sightings.entity.Sighting;
import org.springframework.stereotype.Component;

@Component
public class SightingMapper {
    public Sighting toEntity(SightingRequest sightingRequest) {
        Sighting sighting = new Sighting();
        updateEntity(sighting,sightingRequest);
        if (sighting.getStatus() == null) {
            sighting.setStatus(Status.REPORTED);
        }
        return sighting;
    }

    public void updateEntity(Sighting sighting, SightingRequest sightingRequest) {
        sighting.setSpecies(sightingRequest.species());
        sighting.setRegion(sightingRequest.region());
        sighting.setSightedOn(sightingRequest.sightedOn());
        sighting.setNotes(sightingRequest.notes());
        if (sightingRequest.status() != null) {
            sighting.setStatus(sightingRequest.status());
        }
    }

    public SightingResponse toResponse(Sighting sighting) {
        return new SightingResponse(sighting.getId(), sighting.getSpecies(),sighting.getRegion(),sighting.getSightedOn(),
                sighting.getStatus(),sighting.getNotes());
    }
}
