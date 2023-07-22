package com.example.project1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private String error;
}

