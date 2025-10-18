package com.jolmos.ticarum.sport.competitions.infrastructure.controller;

import com.jolmos.ticarum.sport.competitions.domain.model.exception.CompetitionNotFoundException;
import com.jolmos.ticarum.sport.competitions.domain.model.exception.TeamAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CompetitionNotFoundException.class)
    public ResponseEntity <String> competitionNotFoundExceptionHandler(CompetitionNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TeamAlreadyExistException.class)
    public ResponseEntity <String> teamAlreadyExistExceptionHandler(TeamAlreadyExistException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
}
