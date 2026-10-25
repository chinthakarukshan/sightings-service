package com.nygen.au.sightings.service;

import com.nygen.au.sightings.common.exception.SightingNotFoundException;
import com.nygen.au.sightings.entity.Sighting;
import com.nygen.au.sightings.mapper.SightingMapper;
import com.nygen.au.sightings.repository.SightingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SightingServiceTest {
    @Mock SightingRepository sightingRepository;
    @Spy SightingMapper sightingMapper;
    @InjectMocks SightingService sightingService;

    @Test
    void findById_throwsWhenSightingDoesNotExist() {
        when(sightingRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(SightingNotFoundException.class, () -> sightingService.findById(99L));
    }
}
