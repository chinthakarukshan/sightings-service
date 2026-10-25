package com.nygen.au.sightings.service;

import com.nygen.au.sightings.common.Status;
import com.nygen.au.sightings.common.exception.SightingNotFoundException;
import com.nygen.au.sightings.dto.SightingRequest;
import com.nygen.au.sightings.entity.Sighting;
import com.nygen.au.sightings.mapper.SightingMapper;
import com.nygen.au.sightings.repository.SightingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SightingServiceTest {
    @Mock SightingRepository sightingRepository;
    @Spy SightingMapper sightingMapper;
    @InjectMocks SightingService sightingService;
    @Captor ArgumentCaptor<Sighting> sightingArgumentCaptor;


    @Test
    void findById_throwsWhenSightingDoesNotExist() {
        when(sightingRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(SightingNotFoundException.class, () -> sightingService.findById(99L));
    }

    @Test
    void addSighting_savesDefaultStatusWhenStatusIsNotSet(){
        SightingRequest sightingRequest = new SightingRequest("Elephant","Yala", LocalDate.now(),null,"healthy");

        when(sightingRepository.save(any(Sighting.class))).thenAnswer(invocation -> invocation.getArgument(0));

        sightingService.addSighting(sightingRequest);

        verify(sightingRepository).save(sightingArgumentCaptor.capture());
        Sighting sighting = sightingArgumentCaptor.getValue();
        assertEquals(Status.REPORTED,sighting.getStatus());
        assertEquals("Elephant", sighting.getSpecies());
    }
}
