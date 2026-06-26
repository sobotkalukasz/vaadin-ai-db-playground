package com.example.playground.importer;

public interface ExternalDataImporter {

    String name();

    String displayName();

    String endpointPath();

    ImportResult importData(ImportRequest request);
}
