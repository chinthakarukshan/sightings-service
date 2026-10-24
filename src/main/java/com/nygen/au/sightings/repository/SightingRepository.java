package com.nygen.au.sightings.repository;

import com.nygen.au.sightings.entity.Sighting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SightingRepository extends JpaRepository<Sighting,Long> {
    List<Sighting> findByRegion(String region);
}
