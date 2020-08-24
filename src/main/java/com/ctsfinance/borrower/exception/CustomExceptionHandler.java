package com.ctsfinance.borrower.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleAllExceptions(CustomException ex) {

        ErrorResponse exceptionResponse = new ErrorResponse(ex.getMessage(), ex.getDetails(), ex.getDate());

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
