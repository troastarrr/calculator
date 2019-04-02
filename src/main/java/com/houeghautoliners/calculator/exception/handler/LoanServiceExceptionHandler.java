package com.houeghautoliners.calculator.exception.handler;

import com.houeghautoliners.calculator.exception.InvalidRequestException;
import com.houeghautoliners.calculator.exception.InvalidServiceTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoanServiceExceptionHandler {

    @ExceptionHandler(value = {InvalidServiceTypeException.class})
    protected ResponseEntity<Object> handleServiceTypeException(InvalidServiceTypeException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    @ExceptionHandler(value = {InvalidRequestException.class})
    protected ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
