package com.jolmos.ticarum.sport.competitions.domain.model.exception;

public class TeamAlreadyExist extends RuntimeException {
    public TeamAlreadyExist(String message) {
        super(message);
    }
}
