package com.example.jparelationexercise.Advise;

import com.example.jparelationexercise.Api.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException (ApiException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
    }

}
