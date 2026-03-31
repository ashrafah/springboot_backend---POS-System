package com.example.Pos.advisor;

import com.example.Pos.exception.NotFoundException;
import com.example.Pos.util.StandarardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandarardResponse> handleNotFoundException(NotFoundException e) {
        return new  ResponseEntity<StandarardResponse>(
                new StandarardResponse(404,"Error Comming", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
