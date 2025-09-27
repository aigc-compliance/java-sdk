package com.aigccompliance;

import java.time.Instant;

/**
 * Rate limiting information from API headers
 */
public class RateLimitInfo {
    private final int limit;
    private final int remaining;
    private final Instant reset;
    
    private RateLimitInfo(int limit, int remaining, Instant reset) {
        this.limit = limit;
        this.remaining = remaining;
        this.reset = reset;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private int limit;
        private int remaining;
        private Instant reset;
        
        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }
        
        public Builder remaining(int remaining) {
            this.remaining = remaining;
            return this;
        }
        
        public Builder reset(Instant reset) {
            this.reset = reset;
            return this;
        }
        
        public RateLimitInfo build() {
            return new RateLimitInfo(limit, remaining, reset);
        }
    }
    
    public int getLimit() {
        return limit;
    }
    
    public int getRemaining() {
        return remaining;
    }
    
    public Instant getReset() {
        return reset;
    }
}