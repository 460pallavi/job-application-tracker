package com.job.application.exception;

public class InvalidApplicationStatusException extends RuntimeException{
    public InvalidApplicationStatusException(String message) {
        super(message);
    }
}
