package com.elhawary.accounting.domain;

import org.springframework.http.HttpStatus;

/**
 * Enumeration for standardized API response codes
 */
public enum ResponseCode {
    SUCCESS(HttpStatus.OK, "Request processed successfully"),
    CREATED(HttpStatus.CREATED, "Resource created successfully"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "Invalid request parameters"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Authentication required"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Access denied"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    CONFLICT(HttpStatus.CONFLICT, "Resource conflict"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurred");

    private final HttpStatus httpStatus;
    private final String defaultMessage;

    ResponseCode(HttpStatus httpStatus, String defaultMessage) {
        this.httpStatus = httpStatus;
        this.defaultMessage = defaultMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public int getStatusCode() {
        return httpStatus.value();
    }
}
