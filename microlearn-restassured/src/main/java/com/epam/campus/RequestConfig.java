package com.epam.campus;
import lombok.Data;

@Data
public class RequestConfig {
    private String baseURL;
    private String basePath;
    private String contentType;
    public RequestConfig() {
        this.baseURL = "http://localhost:9000";
        this.basePath = "/api";
        this.contentType = "application/json"; // Default to JSON
    }

}
