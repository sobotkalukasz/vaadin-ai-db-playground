package com.example.playground.config;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external-api")
public class ExternalApiProperties {
    private String baseUrl = "http://localhost:8081";
    private Map<String, ImporterProperties> importers = new LinkedHashMap<>();
    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
    public Map<String, ImporterProperties> getImporters() { return importers; }
    public void setImporters(Map<String, ImporterProperties> importers) { this.importers = importers; }
    public static class ImporterProperties {
        private boolean enabled = true; private String path; private String displayName;
        public boolean isEnabled() { return enabled; } public void setEnabled(boolean enabled) { this.enabled = enabled; }
        public String getPath() { return path; } public void setPath(String path) { this.path = path; }
        public String getDisplayName() { return displayName; } public void setDisplayName(String displayName) { this.displayName = displayName; }
    }
}
