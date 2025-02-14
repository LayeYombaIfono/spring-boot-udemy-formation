package com.hamilatech.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(ProductNotFoundException ex){
        Map<String, String> response = new HashMap<>();

        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProductRegistrationException.class)
    public ResponseEntity<Map<String, String>>handleProductRegistrationException(ProductRegistrationException ex){
        Map<String, String> response = new HashMap<>();

        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>>handleRuntimeException(RuntimeException ex){
        Map<String, String> response = new HashMap<>();

        response.put("Error", "Une erreur interne est survenue : " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }


}
