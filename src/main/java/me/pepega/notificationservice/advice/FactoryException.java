package me.pepega.notificationservice.advice;

import me.pepega.notificationservice.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class FactoryException {
    public ResponseEntity<ExceptionResponse> build(HttpStatus status, String message){
        return ResponseEntity
                .status(status)
                .body(new ExceptionResponse(message));
    }
}
