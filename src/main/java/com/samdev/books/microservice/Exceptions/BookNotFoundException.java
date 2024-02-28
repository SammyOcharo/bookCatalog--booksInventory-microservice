package com.samdev.books.microservice.Exceptions;

public class BookNotFoundException extends  RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
