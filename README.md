# AIGC Compliance Java SDK

Official Java SDK for AIGC Compliance API - Automated compliance for AI-generated content in EU and China markets.

## Features

✅ **Complete API Coverage** - Implements all parameters from [official documentation](https://www.aigc-compliance.com/docs)  
✅ **EU & China Compliance** - C2PA metadata injection for EU AI Act and watermarking for China Cybersecurity Law  
✅ **Type-Safe** - Full Java type safety with comprehensive error handling  
✅ **Enterprise Ready** - Built-in retry logic, rate limiting, and timeout handling  
✅ **Easy Integration** - Simple, intuitive API design  

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.aigc-compliance</groupId>
    <artifactId>aigc-compliance-sdk</artifactId>
    <version>1.0.2</version>
</dependency>
```

### Gradle

Add this to your `build.gradle`:

```gradle
implementation 'com.aigc-compliance:aigc-compliance-sdk:1.0.2'
```

## Quick Start

```java
import com.aigccompliance.*;

public class Example {
    public static void main(String[] args) {
        // Initialize client
        ComplianceClient client = new ComplianceClient("your-api-key");
        
        // Configure compliance options (all parameters from official docs)
        ComplianceOptions options = ComplianceOptions.builder()
            .region("EU")  // "EU" or "CN"
            .watermarkText("My Company")  // Custom watermark text
            .watermarkPosition("bottom-right")  // Position control
            .includeBase64(true)  // Include base64 in response
            .saveToDisk(true)  // Save to disk
            .build();
        
        try {
            // Process image
            byte[] imageData = Files.readAllBytes(Paths.get("image.jpg"));
            ComplianceResponse response = client.comply(imageData, options);
            
            if (response.isSuccess()) {
                System.out.println("✅ Processed! Download: " + response.getDownloadUrl());
                System.out.println("Credits remaining: " + response.getCreditsRemaining());
            }
        } catch (ComplianceAPIException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
```

## API Parameters

This SDK implements **all parameters** from the [official AIGC Compliance API documentation](https://www.aigc-compliance.com/docs):

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `file` | `byte[]` | ✅ | Image file data (PNG, JPG, JPEG, max 10MB) |
| `region` | `String` | ✅ | Compliance region: `"EU"` or `"CN"` |
| `watermark_text` | `String` | ❌ | Custom watermark text (plan restrictions apply) |
| `watermark_position` | `String` | ❌ | Position: `"bottom-right"`, `"bottom-left"`, `"top-right"`, `"top-left"` |
| `logo_file` | `byte[]` | ❌ | Logo file for watermark (PNG/JPEG, plan restrictions apply) |
| `include_base64` | `boolean` | ❌ | Include base64 in response (default: `false`) |
| `save_to_disk` | `boolean` | ❌ | Save processed file to disk (default: `true`) |

## Advanced Usage

### Custom Client Configuration

```java
ClientOptions clientOptions = ClientOptions.builder()
    .baseUrl("https://api.aigc-compliance.com")
    .timeout(60)  // seconds
    .maxRetries(5)
    .userAgent("MyApp/2.0")
    .build();

ComplianceClient client = new ComplianceClient("your-api-key", clientOptions);
```

### File Upload with Logo

```java
ComplianceOptions options = ComplianceOptions.builder()
    .region("CN")
    .watermarkText("Company Name")
    .watermarkPosition("bottom-left")
    .logoFile(Files.readAllBytes(Paths.get("logo.png")))  // Add company logo
    .includeBase64(false)
    .build();

ComplianceResponse response = client.comply(imageData, options);
```

### Error Handling

```java
try {
    ComplianceResponse response = client.comply(imageData, options);
    // Process success response
} catch (ComplianceAuthenticationException e) {
    // Handle authentication errors (401)
    System.err.println("Invalid API key: " + e.getMessage());
} catch (ComplianceQuotaExceededException e) {
    // Handle quota exceeded (402)
    System.err.println("Quota exceeded: " + e.getMessage());
} catch (ComplianceValidationException e) {
    // Handle validation errors (422)
    System.err.println("Validation error: " + e.getMessage());
} catch (ComplianceRateLimitException e) {
    // Handle rate limiting (429)
    System.err.println("Rate limited. Retry after: " + e.getRetryAfter() + " seconds");
} catch (ComplianceAPIException e) {
    // Handle other API errors
    System.err.println("API error: " + e.getMessage() + " (Code: " + e.getStatusCode() + ")");
}
```

## Response Structure

```java
ComplianceResponse response = client.comply(imageData, options);

// Basic response info
response.getStatus();                    // "success"
response.getRegionApplied();             // "EU" or "CN" 
response.getTimestamp();                 // "2025-09-27T12:34:56Z"
response.getProcessingTimeMs();          // 127

// File information  
response.getFileHash();                  // "sha256:a1b2c3d4e5f6789..."
response.getOriginalFilename();          // "ai-generated-image.jpg"
response.getDownloadUrl();               // Download URL for processed image
response.getDownloadExpiresAt();         // URL expiration time

// Compliance metadata
response.getComplianceMetadata();        // Detailed compliance info
response.isAiGenerated();               // Convenience method

// Usage info
response.getCreditsUsed();              // Credits consumed
response.getCreditsRemaining();         // Credits remaining

// Optional base64 (if requested)
response.getProcessedImageBase64();     // Base64 encoded result
```

## Compliance Regions

### EU Region (AI Act Compliance)
- **Method**: C2PA metadata injection
- **Output**: PNG with embedded C2PA metadata
- **Standards**: EU AI Act transparency requirements
- **Verification**: Compatible with C2PA verification tools

### CN Region (Cybersecurity Law Compliance)  
- **Method**: Visible/invisible watermarking + content labeling
- **Output**: Watermarked image with compliance labels
- **Standards**: China Cybersecurity Law requirements
- **Features**: Robust watermark detection and content labeling

## Requirements

- **Java**: 8 or higher
- **Dependencies**: OkHttp 4.12.0, Jackson 2.15.2
- **Maven/Gradle**: For dependency management

## Error Codes

| Code | Exception | Description | Solution |
|------|-----------|-------------|----------|
| 401 | `ComplianceAuthenticationException` | Invalid API key | Check Authorization header |
| 402 | `ComplianceQuotaExceededException` | Monthly quota exceeded | Upgrade plan or wait for reset |
| 422 | `ComplianceValidationException` | Invalid request parameters | Check file format and parameters |
| 429 | `ComplianceRateLimitException` | Rate limit exceeded | Wait and retry with exponential backoff |
| 5xx | `ComplianceServerException` | Server error | Retry request or contact support |

## Official Documentation

This SDK implements the complete [AIGC Compliance API](https://www.aigc-compliance.com/docs). For the most up-to-date API reference, parameter details, and compliance standards, visit the official documentation.

## License

MIT License - see LICENSE file for details.

## Support

- **Documentation**: [https://www.aigc-compliance.com/docs](https://www.aigc-compliance.com/docs)
- **Issues**: [GitHub Issues](https://github.com/aigc-compliance/java-sdk/issues) 
- **Email**: support@aigc-compliance.com