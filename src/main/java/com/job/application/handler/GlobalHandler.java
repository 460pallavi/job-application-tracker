package com.job.application.handler;

import com.job.application.exception.*;
import com.job.application.repository.ApplicationRepository;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ApplicationAlreadyExistException.class)
     public ResponseEntity<String> alreadyExist(){
        return ResponseEntity.badRequest().body("Job application already exists");
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<String> ApplicationNotFound(){
        return ResponseEntity.status(404).body("Id not found");
    }
    @ExceptionHandler(InvalidApplicationStatusException.class)
    public ResponseEntity<String> invalidRequest(){
        return ResponseEntity.status(500).body("Internal Server Error");
    }
    @ExceptionHandler(InvalidStatusTransitionsException.class)
    public ResponseEntity<String> invalidStatus(){
        return ResponseEntity.status(404).body("Invalid Status");
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> notValid(
            MethodArgumentNotValidException ex){

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errors);
    }

    }

