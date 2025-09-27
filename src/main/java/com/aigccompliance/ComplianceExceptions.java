package com.aigccompliance;

import java.util.Map;

/**
 * Base exception for AIGC Compliance API errors
 */
class ComplianceAPIException extends Exception {
    private final int statusCode;
    private final Map<String, Object> errorData;
    
    public ComplianceAPIException(String message) {
        this(message, 0, null);
    }
    
    public ComplianceAPIException(String message, int statusCode) {
        this(message, statusCode, null);
    }
    
    public ComplianceAPIException(String message, int statusCode, Map<String, Object> errorData) {
        super(message);
        this.statusCode = statusCode;
        this.errorData = errorData;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public Map<String, Object> getErrorData() {
        return errorData;
    }
}

/**
 * Network/connectivity related errors
 */
class ComplianceNetworkException extends ComplianceAPIException {
    public ComplianceNetworkException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}

/**
 * Authentication errors (401)
 */
class ComplianceAuthenticationException extends RuntimeException {
    public ComplianceAuthenticationException(String message) {
        super(message);
    }
    
    public ComplianceAuthenticationException(String message, Map<String, Object> errorData) {
        super(message);
    }
}

/**
 * Quota exceeded errors (402)
 */
class ComplianceQuotaExceededException extends ComplianceAPIException {
    public ComplianceQuotaExceededException(String message, Map<String, Object> errorData) {
        super(message, 402, errorData);
    }
}

/**
 * Validation errors (422)
 */
class ComplianceValidationException extends ComplianceAPIException {
    public ComplianceValidationException(String message) {
        super(message, 422);
    }
    
    public ComplianceValidationException(String message, Map<String, Object> errorData) {
        super(message, 422, errorData);
    }
}

/**
 * Rate limiting errors (429)
 */
class ComplianceRateLimitException extends ComplianceAPIException {
    private final Integer retryAfter;
    
    public ComplianceRateLimitException(String message, Integer retryAfter, Map<String, Object> errorData) {
        super(message, 429, errorData);
        this.retryAfter = retryAfter;
    }
    
    public Integer getRetryAfter() {
        return retryAfter;
    }
}

/**
 * Server errors (5xx)
 */
class ComplianceServerException extends ComplianceAPIException {
    public ComplianceServerException(String message, Map<String, Object> errorData) {
        super(message, 500, errorData);
    }
}