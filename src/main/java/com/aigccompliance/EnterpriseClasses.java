package com.aigccompliance;

import java.util.List;

/**
 * Enterprise feature classes
 */

class AnalyticsOptions {
    private String period;
    private String startDate;
    private String endDate;
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final AnalyticsOptions options = new AnalyticsOptions();
        
        public Builder period(String period) {
            options.period = period;
            return this;
        }
        
        public Builder startDate(String startDate) {
            options.startDate = startDate;
            return this;
        }
        
        public Builder endDate(String endDate) {
            options.endDate = endDate;
            return this;
        }
        
        public AnalyticsOptions build() {
            return options;
        }
    }
    
    public String getPeriod() { return period; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
}

class AnalyticsResponse {
    private String period;
    private int totalRequests;
    private int successfulRequests;
    private int failedRequests;
    private double avgProcessingTime;
    
    // Getters and setters
    public String getPeriod() { return period; }
    public void setPeriod(String period) { this.period = period; }
    
    public int getTotalRequests() { return totalRequests; }
    public void setTotalRequests(int totalRequests) { this.totalRequests = totalRequests; }
    
    public int getSuccessfulRequests() { return successfulRequests; }
    public void setSuccessfulRequests(int successfulRequests) { this.successfulRequests = successfulRequests; }
    
    public int getFailedRequests() { return failedRequests; }
    public void setFailedRequests(int failedRequests) { this.failedRequests = failedRequests; }
    
    public double getAvgProcessingTime() { return avgProcessingTime; }
    public void setAvgProcessingTime(double avgProcessingTime) { this.avgProcessingTime = avgProcessingTime; }
}

class WebhookOptions {
    private String url;
    private List<String> events;
    private String secret;
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final WebhookOptions options = new WebhookOptions();
        
        public Builder url(String url) {
            options.url = url;
            return this;
        }
        
        public Builder events(List<String> events) {
            options.events = events;
            return this;
        }
        
        public Builder secret(String secret) {
            options.secret = secret;
            return this;
        }
        
        public WebhookOptions build() {
            return options;
        }
    }
    
    public String getUrl() { return url; }
    public List<String> getEvents() { return events; }
    public String getSecret() { return secret; }
}

class WebhookRegistration {
    private String id;
    private String url;
    private List<String> events;
    private String status;
    
    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public List<String> getEvents() { return events; }
    public void setEvents(List<String> events) { this.events = events; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

class QuotaInfo {
    private int totalQuota;
    private int usedQuota;
    private int remainingQuota;
    private String resetDate;
    
    // Getters and setters
    public int getTotalQuota() { return totalQuota; }
    public void setTotalQuota(int totalQuota) { this.totalQuota = totalQuota; }
    
    public int getUsedQuota() { return usedQuota; }
    public void setUsedQuota(int usedQuota) { this.usedQuota = usedQuota; }
    
    public int getRemainingQuota() { return remainingQuota; }
    public void setRemainingQuota(int remainingQuota) { this.remainingQuota = remainingQuota; }
    
    public String getResetDate() { return resetDate; }
    public void setResetDate(String resetDate) { this.resetDate = resetDate; }
}