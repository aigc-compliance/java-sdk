package com.aigccompliance;

/**
 * Options for processing compliance requests
 * 
 * Contains all configuration options based on official AIGC Compliance API documentation
 */
public class ComplianceOptions {
    private String region = "EU";  // "EU" or "CN"
    private String watermarkText;
    private String watermarkPosition = "bottom-right";  // "bottom-right", "bottom-left", "top-right", "top-left"
    private byte[] logoFile;
    private boolean includeBase64 = false;
    private boolean saveToDisk = true;
    private String metadataLevel = "basic";  // "basic" or "detailed"
    private boolean watermarkLogo = false;
    
    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private final ComplianceOptions options = new ComplianceOptions();
        
        public Builder region(String region) {
            options.region = region;
            return this;
        }
        
        public Builder watermarkText(String watermarkText) {
            options.watermarkText = watermarkText;
            return this;
        }
        
        public Builder watermarkPosition(String watermarkPosition) {
            options.watermarkPosition = watermarkPosition;
            return this;
        }
        
        public Builder logoFile(byte[] logoFile) {
            options.logoFile = logoFile;
            return this;
        }
        
        public Builder includeBase64(boolean includeBase64) {
            options.includeBase64 = includeBase64;
            return this;
        }
        
        public Builder saveToDisk(boolean saveToDisk) {
            options.saveToDisk = saveToDisk;
            return this;
        }
        
        public Builder metadataLevel(String metadataLevel) {
            options.metadataLevel = metadataLevel;
            return this;
        }
        
        public Builder watermarkLogo(boolean watermarkLogo) {
            options.watermarkLogo = watermarkLogo;
            return this;
        }
        
        public ComplianceOptions build() {
            return options;
        }
    }
    
    // Getters
    public String getRegion() {
        return region;
    }
    
    public String getWatermarkText() {
        return watermarkText;
    }
    
    public String getWatermarkPosition() {
        return watermarkPosition;
    }
    
    public byte[] getLogoFile() {
        return logoFile;
    }
    
    public boolean isIncludeBase64() {
        return includeBase64;
    }
    
    public boolean isSaveToDisk() {
        return saveToDisk;
    }
    
    public String getMetadataLevel() {
        return metadataLevel;
    }
    
    public boolean isWatermarkLogo() {
        return watermarkLogo;
    }
}