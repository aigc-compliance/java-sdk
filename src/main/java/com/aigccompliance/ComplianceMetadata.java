package com.aigccompliance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Compliance metadata from API response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplianceMetadata {
    
    @JsonProperty("processing_method")
    private String processingMethod;
    
    @JsonProperty("compliant")
    private boolean compliant;
    
    @JsonProperty("region_specific_data")
    private Map<String, Object> regionSpecificData;
    
    @JsonProperty("processing_details")
    private Map<String, Object> processingDetails;
    
    // Getters and setters
    public String getProcessingMethod() {
        return processingMethod;
    }
    
    public void setProcessingMethod(String processingMethod) {
        this.processingMethod = processingMethod;
    }
    
    public boolean isCompliant() {
        return compliant;
    }
    
    public void setCompliant(boolean compliant) {
        this.compliant = compliant;
    }
    
    public Map<String, Object> getRegionSpecificData() {
        return regionSpecificData;
    }
    
    public void setRegionSpecificData(Map<String, Object> regionSpecificData) {
        this.regionSpecificData = regionSpecificData;
    }
    
    public Map<String, Object> getProcessingDetails() {
        return processingDetails;
    }
    
    public void setProcessingDetails(Map<String, Object> processingDetails) {
        this.processingDetails = processingDetails;
    }
}