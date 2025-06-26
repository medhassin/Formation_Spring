package com.zeus.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MissingEntityException.class )
    public ResponseEntity<String> handleMissingEntityException(MissingEntityException ex ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }

    @ExceptionHandler(ConnectException.class )
    public ResponseEntity<String> handleConnectException(ConnectException ex ) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("SERVICE IS CURRENTLY UNAVAILABLE.Please try again");
    }

}
