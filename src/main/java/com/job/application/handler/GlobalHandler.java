package com.job.application.handler;

import com.job.application.exception.ApplicationAlreadyExistException;
import com.job.application.exception.ApplicationNotFoundException;
import com.job.application.exception.InvalidApplicationStatusException;
import com.job.application.exception.InvalidStatusTransitionsException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
    public ResponseEntity<String> InvalidStatus(){
        return ResponseEntity.status(404).body("Invalid Status");
    }
}
