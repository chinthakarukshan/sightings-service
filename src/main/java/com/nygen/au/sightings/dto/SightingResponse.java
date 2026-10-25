package com.nygen.au.sightings.dto;

import com.nygen.au.sightings.common.Status;

import java.time.LocalDate;

public record SightingResponse(
        Long id,
        String species,
        String region,
        LocalDate sightedOn,
        Status status,
        String notes
) {
}
