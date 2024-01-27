package com.backend_labs.stuff.exceptions;

public class DoesntExistsException extends RuntimeException {
    public DoesntExistsException(String message){
        super(message);
    }
}
