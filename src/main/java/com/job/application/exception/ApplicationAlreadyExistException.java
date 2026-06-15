package com.job.application.exception;

public class ApplicationAlreadyExistException extends RuntimeException{

    public ApplicationAlreadyExistException(String Message) {
        super(Message);
    }
}
