package com.example.playground.importer.firstendpoint;

import com.example.playground.config.ExternalApiProperties;
import com.example.playground.importer.ExternalDataImporter;
import com.example.playground.importer.ImportRequest;
import com.example.playground.importer.ImportResult;
import com.example.playground.model.ImportStatus;
import org.springframework.stereotype.Component;

@Component
public class FirstEndpointImporter implements ExternalDataImporter {

    public static final String NAME = "first-endpoint";

    private final ExternalApiProperties props;

    public FirstEndpointImporter(ExternalApiProperties props) {
        this.props = props;
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String displayName() {
        String displayName = cfg().getDisplayName();
        return displayName == null || displayName.isBlank() ? "First endpoint" : displayName;
    }

    @Override
    public String endpointPath() {
        String path = cfg().getPath();
        return path == null || path.isBlank() ? "not configured" : path;
    }

    @Override
    public ImportResult importData(ImportRequest request) {
        return new ImportResult(
                NAME,
                ImportStatus.FAILED,
                0,
                "External API import is not implemented yet.");
    }

    private ExternalApiProperties.ImporterProperties cfg() {
        return props.getImporters().getOrDefault(NAME, new ExternalApiProperties.ImporterProperties());
    }
}
