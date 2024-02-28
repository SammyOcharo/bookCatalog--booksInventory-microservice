package com.samdev.books.microservice.Exceptions;

public class InvalidIDException extends RuntimeException{

    public InvalidIDException(String message) {
        super(message);
    }
}
