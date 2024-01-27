package com.backend_labs.stuff.exceptions;

public class EmptyFieldException extends RuntimeException{
    public  EmptyFieldException(String message){
         super(message);
    }
}
