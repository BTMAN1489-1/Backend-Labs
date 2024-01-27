package com.backend_labs.stuff.exceptions;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class UserControllerExceptionHandler {
    @ExceptionHandler({DoesntExistsException.class})
    public ResponseEntity<?> exception(DoesntExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AlreadyExistsException.class, EmptyFieldException.class})
    public ResponseEntity<?> exception(RuntimeException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({PropertyValueException.class, SQLException.class, NullPointerException.class})
    public ResponseEntity<?> exception(Exception exception) {
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

}
