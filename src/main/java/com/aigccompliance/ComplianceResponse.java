package com.aigccompliance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Response from AIGC Compliance API
 * 
 * Based on official API documentation response schema
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplianceResponse {
    
    @JsonProperty("status")
    private String status;
    
    @JsonProperty("region_applied")
    private String regionApplied;
    
    @JsonProperty("timestamp")
    private String timestamp;
    
    @JsonProperty("file_hash")
    private String fileHash;
    
    @JsonProperty("original_filename")
    private String originalFilename;
    
    @JsonProperty("compliance_metadata")
    private ComplianceMetadata complianceMetadata;
    
    @JsonProperty("download_url")
    private String downloadUrl;
    
    @JsonProperty("download_expires_at")
    private String downloadExpiresAt;
    
    @JsonProperty("processed_image_base64")
    private String processedImageBase64;
    
    @JsonProperty("processing_time_ms")
    private Integer processingTimeMs;
    
    @JsonProperty("credits_used")
    private Integer creditsUsed;
    
    @JsonProperty("credits_remaining")
    private Integer creditsRemaining;
    
    // Rate limit info (set by client)
    private RateLimitInfo rateLimitInfo;
    
    // Getters and setters
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRegionApplied() {
        return regionApplied;
    }
    
    public void setRegionApplied(String regionApplied) {
        this.regionApplied = regionApplied;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getFileHash() {
        return fileHash;
    }
    
    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }
    
    public String getOriginalFilename() {
        return originalFilename;
    }
    
    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }
    
    public ComplianceMetadata getComplianceMetadata() {
        return complianceMetadata;
    }
    
    public void setComplianceMetadata(ComplianceMetadata complianceMetadata) {
        this.complianceMetadata = complianceMetadata;
    }
    
    public String getDownloadUrl() {
        return downloadUrl;
    }
    
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    
    public String getDownloadExpiresAt() {
        return downloadExpiresAt;
    }
    
    public void setDownloadExpiresAt(String downloadExpiresAt) {
        this.downloadExpiresAt = downloadExpiresAt;
    }
    
    public String getProcessedImageBase64() {
        return processedImageBase64;
    }
    
    public void setProcessedImageBase64(String processedImageBase64) {
        this.processedImageBase64 = processedImageBase64;
    }
    
    public Integer getProcessingTimeMs() {
        return processingTimeMs;
    }
    
    public void setProcessingTimeMs(Integer processingTimeMs) {
        this.processingTimeMs = processingTimeMs;
    }
    
    public Integer getCreditsUsed() {
        return creditsUsed;
    }
    
    public void setCreditsUsed(Integer creditsUsed) {
        this.creditsUsed = creditsUsed;
    }
    
    public Integer getCreditsRemaining() {
        return creditsRemaining;
    }
    
    public void setCreditsRemaining(Integer creditsRemaining) {
        this.creditsRemaining = creditsRemaining;
    }
    
    public RateLimitInfo getRateLimitInfo() {
        return rateLimitInfo;
    }
    
    public void setRateLimitInfo(RateLimitInfo rateLimitInfo) {
        this.rateLimitInfo = rateLimitInfo;
    }
    
    // Convenience methods
    public boolean isSuccess() {
        return "success".equals(status);
    }
    
    public boolean isAiGenerated() {
        return complianceMetadata != null && complianceMetadata.isCompliant();
    }
}