package com.example.usuario.controller;

import com.example.usuario.infrastructure.exceptions.ConflictException;
import com.example.usuario.infrastructure.exceptions.IllegalArgumentException;
import com.example.usuario.infrastructure.exceptions.ResourceNotFoundException;
import com.example.usuario.infrastructure.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.module.ResolutionException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResolutionException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> handleConflictException(ConflictException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleConflictException(UnauthorizedException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
