package me.pepega.notificationservice.advice;

import me.pepega.notificationservice.dto.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FactoryExceptionBuild {
    public ResponseEntity<ExceptionResponse> build(HttpStatus status, String message){
        return ResponseEntity
                .status(status)
                .body(new ExceptionResponse(message));
    }
}
