package com.ren0five.springbootblogrestapi.controllers;

import com.ren0five.springbootblogrestapi.exceptions.NoBlogDataFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogsExceptionsController {

    @ExceptionHandler(NoBlogDataFoundException.class)
    public ResponseEntity<String> noBlogDataFound(NoBlogDataFoundException ex) {
        String errorDetails = ex.getMessage();
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

}
