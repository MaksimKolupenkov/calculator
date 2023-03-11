package com.example.calculator.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorMessage extends RuntimeException {

    public ErrorMessage(String reason, HttpStatus paymentRequired) {
        super(reason);
    }

}