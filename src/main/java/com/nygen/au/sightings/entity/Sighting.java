package com.nygen.au.sightings.entity;

import com.nygen.au.sightings.common.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Sighting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String species;

    private String region;

    private LocalDate sightedOn;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String notes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LocalDate getSightedOn() {
        return sightedOn;
    }

    public void setSightedOn(LocalDate sightedOn) {
        this.sightedOn = sightedOn;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
