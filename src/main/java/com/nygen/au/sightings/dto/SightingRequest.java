package com.nygen.au.sightings.dto;

import com.nygen.au.sightings.common.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record SightingRequest(
        @NotBlank String species,
        @NotBlank String region,
        @NotNull @PastOrPresent LocalDate sightedOn,
        Status status,
        @Size(max = 500) String notes
) {
}
