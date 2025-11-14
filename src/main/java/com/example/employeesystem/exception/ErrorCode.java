package com.example.employeesystem.exception;


public enum ErrorCode {

    SUCCESS(0, "Success"),

    // 4xx client errors
    BAD_REQUEST(400, "Bad request"),
    NOT_FOUND(404, "Resource not found"),
    VALIDATION_ERROR(422, "Validation failed"),

    // 5xx server errors
    INTERNAL_SERVER_ERROR(500, "Internal server error"),

    // business layer codes
    BUSINESS_ERROR(1001, "Business logic error");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
