package com.job.application.exception;

public class InvalidStatusTransitionsException extends RuntimeException{
    public InvalidStatusTransitionsException(String message) {
        super(message);
    }
}
