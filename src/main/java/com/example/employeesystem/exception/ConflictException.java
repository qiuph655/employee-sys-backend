package com.example.employeesystem.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends BusinessException{
    public ConflictException(String message) {
        super(ErrorCode.CONFLICT,message);
    }
}
