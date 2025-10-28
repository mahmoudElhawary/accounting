package com.elhawary.accounting.exception;

import com.elhawary.accounting.domain.AppResponse;
import com.elhawary.accounting.domain.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for centralized exception handling
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handle validation errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppResponse<Map<String, String>>> handleValidationExceptions(
            MethodArgumentNotValidException ex, WebRequest request) {

        log.warn("Validation failed - path: {}, errors: {}",
                request.getDescription(false), ex.getBindingResult().getErrorCount());

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return AppResponse.<Map<String, String>>builder()
                .status(ResponseCode.BAD_REQUEST)
                .message("Validation failed")
                .data(errors)
                .buildEntity();
    }

    /**
     * Handle invalid request exceptions
     */
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<AppResponse<Void>> handleInvalidRequestException(
            InvalidRequestException ex, WebRequest request) {

        log.warn("Invalid request - path: {}, message: {}",
                request.getDescription(false), ex.getMessage());

        return AppResponse.<Void>builder()
                .status(ResponseCode.BAD_REQUEST)
                .message(ex.getMessage())
                .buildEntity();
    }

    /**
     * Handle resource not found exceptions
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppResponse<Void>> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {

        log.warn("Resource not found - path: {}, message: {}",
                request.getDescription(false), ex.getMessage());

        return AppResponse.<Void>builder()
                .status(ResponseCode.NOT_FOUND)
                .message(ex.getMessage())
                .buildEntity();
    }

    /**
     * Handle business logic exceptions
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<AppResponse<Void>> handleBusinessException(
            BusinessException ex, WebRequest request) {

        log.warn("Business logic error - path: {}, message: {}",
                request.getDescription(false), ex.getMessage());

        return AppResponse.<Void>builder()
                .status(ResponseCode.BAD_REQUEST)
                .message(ex.getMessage())
                .buildEntity();
    }

    /**
     * Handle unauthorized access exceptions
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<AppResponse<Void>> handleUnauthorizedException(
            UnauthorizedException ex, WebRequest request) {

        log.warn("Unauthorized access - path: {}, message: {}",
                request.getDescription(false), ex.getMessage());

        return AppResponse.<Void>builder()
                .status(ResponseCode.FORBIDDEN)
                .message(ex.getMessage())
                .buildEntity();
    }

    /**
     * Handle illegal argument exceptions
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<AppResponse<Void>> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {

        log.warn("Illegal argument - path: {}, message: {}",
                request.getDescription(false), ex.getMessage());

        return AppResponse.<Void>builder()
                .status(ResponseCode.BAD_REQUEST)
                .message("Invalid parameter: " + ex.getMessage())
                .buildEntity();
    }

    /**
     * Handle all other exceptions
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppResponse<Void>> handleGlobalException(
            Exception ex, WebRequest request) {

        log.error("Unexpected error - path: {}, message: {}",
                request.getDescription(false), ex.getMessage(), ex);

        return AppResponse.<Void>builder()
                .status(ResponseCode.INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred. Please try again later.")
                .info("errorType", ex.getClass().getSimpleName())
                .buildEntity();
    }
}
