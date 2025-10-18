package com.jolmos.ticarum.sport.competitions.domain.model.exception;

public class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException(String message) {
        super(message);
    }
}
