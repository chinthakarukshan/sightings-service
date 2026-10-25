package com.nygen.au.sightings.common.exception;

public class SightingNotFoundException extends RuntimeException {
    public SightingNotFoundException(String message) {
        super(message);
    }
}
