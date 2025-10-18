package com.jolmos.ticarum.sport.competitions.domain.model.exception;

public class TeamAlreadyExistException extends RuntimeException {
    public TeamAlreadyExistException(String message) {
        super(message);
    }
}
