package com.example.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class OperationExceptionController {

    @ExceptionHandler
    public ResponseEntity<String> mismatchException(ErrorMessage exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);



    }
}
