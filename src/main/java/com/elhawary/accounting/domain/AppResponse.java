package com.elhawary.accounting.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic API response wrapper with builder pattern
 * @param <T> Type of data being returned
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int statusCode;
    private String message;
    private T data;
    private LocalDateTime timestamp;
    private Map<String, Object> additionalInfo;

    private AppResponse(ResponseBuilder<T> builder) {
        this.statusCode = builder.status != null ? builder.status.getStatusCode() : 200;
        this.message = builder.message != null ? builder.message :
                      (builder.status != null ? builder.status.getDefaultMessage() : "Success");
        this.data = builder.data;
        this.timestamp = LocalDateTime.now();
        this.additionalInfo = builder.additionalInfo;
    }

    public static <T> ResponseBuilder<T> builder() {
        return new ResponseBuilder<>();
    }

    // Getters
    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Builder class for AppResponse
     */
    public static class ResponseBuilder<T> {
        private ResponseCode status;
        private String message;
        private T data;
        private Map<String, Object> additionalInfo;

        public ResponseBuilder<T> status(ResponseCode status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseBuilder<T> info(String key, Object value) {
            if (this.additionalInfo == null) {
                this.additionalInfo = new HashMap<>();
            }
            this.additionalInfo.put(key, value);
            return this;
        }

        public AppResponse<T> build() {
            return new AppResponse<>(this);
        }

        public ResponseEntity<AppResponse<T>> buildEntity() {
            AppResponse<T> response = build();
            return ResponseEntity
                    .status(this.status != null ? this.status.getHttpStatus() : 200)
                    .body(response);
        }
    }

    /**
     * Convenience method to get ResponseEntity from AppResponse
     */
    public ResponseEntity<AppResponse<T>> getResponseEntity() {
        ResponseCode code = ResponseCode.SUCCESS;
        for (ResponseCode rc : ResponseCode.values()) {
            if (rc.getStatusCode() == this.statusCode) {
                code = rc;
                break;
            }
        }
        return ResponseEntity.status(code.getHttpStatus()).body(this);
    }
}
