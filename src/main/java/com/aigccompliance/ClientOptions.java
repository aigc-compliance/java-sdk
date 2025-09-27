package com.aigccompliance;

/**
 * Configuration options for AIGC Compliance client
 */
public class ClientOptions {
    private String baseUrl;
    private Integer timeout;
    private Integer maxRetries;
    private String userAgent;
    
    public ClientOptions() {
        // Default constructor
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final ClientOptions options = new ClientOptions();
        
        public Builder baseUrl(String baseUrl) {
            options.baseUrl = baseUrl;
            return this;
        }
        
        public Builder timeout(Integer timeout) {
            options.timeout = timeout;
            return this;
        }
        
        public Builder maxRetries(Integer maxRetries) {
            options.maxRetries = maxRetries;
            return this;
        }
        
        public Builder userAgent(String userAgent) {
            options.userAgent = userAgent;
            return this;
        }
        
        public ClientOptions build() {
            return options;
        }
    }
    
    // Getters
    public String getBaseUrl() {
        return baseUrl;
    }
    
    public Integer getTimeout() {
        return timeout;
    }
    
    public Integer getMaxRetries() {
        return maxRetries;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
}