package com.example.demo14.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
