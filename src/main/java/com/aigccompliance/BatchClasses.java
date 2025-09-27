package com.aigccompliance;

import java.util.List;
import java.util.Map;

/**
 * Enterprise batch processing classes
 */

class BatchItem {
    private final byte[] imageData;
    private final Map<String, Object> customMetadata;
    
    public BatchItem(byte[] imageData, Map<String, Object> customMetadata) {
        this.imageData = imageData;
        this.customMetadata = customMetadata;
    }
    
    public byte[] getImageData() {
        return imageData;
    }
    
    public Map<String, Object> getCustomMetadata() {
        return customMetadata;
    }
}

class BatchOptions {
    private String region = "EU";
    private boolean watermarkLogo = false;
    private String metadataLevel = "basic";
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final BatchOptions options = new BatchOptions();
        
        public Builder region(String region) {
            options.region = region;
            return this;
        }
        
        public Builder watermarkLogo(boolean watermarkLogo) {
            options.watermarkLogo = watermarkLogo;
            return this;
        }
        
        public Builder metadataLevel(String metadataLevel) {
            options.metadataLevel = metadataLevel;
            return this;
        }
        
        public BatchOptions build() {
            return options;
        }
    }
    
    public String getRegion() { return region; }
    public boolean isWatermarkLogo() { return watermarkLogo; }
    public String getMetadataLevel() { return metadataLevel; }
}

class BatchResponse {
    private String status;
    private List<ComplianceResponse> results;
    private int totalProcessed;
    private int successCount;
    private int failureCount;
    private RateLimitInfo rateLimitInfo;
    
    // Getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public List<ComplianceResponse> getResults() { return results; }
    public void setResults(List<ComplianceResponse> results) { this.results = results; }
    
    public int getTotalProcessed() { return totalProcessed; }
    public void setTotalProcessed(int totalProcessed) { this.totalProcessed = totalProcessed; }
    
    public int getSuccessCount() { return successCount; }
    public void setSuccessCount(int successCount) { this.successCount = successCount; }
    
    public int getFailureCount() { return failureCount; }
    public void setFailureCount(int failureCount) { this.failureCount = failureCount; }
    
    public RateLimitInfo getRateLimitInfo() { return rateLimitInfo; }
    public void setRateLimitInfo(RateLimitInfo rateLimitInfo) { this.rateLimitInfo = rateLimitInfo; }
}