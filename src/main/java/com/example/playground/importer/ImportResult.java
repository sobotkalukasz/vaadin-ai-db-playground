package com.example.playground.importer;

import com.example.playground.model.ImportStatus;

public record ImportResult(
        String importerName,
        ImportStatus status,
        int importedCount,
        String sanitizedMessage) {

    public boolean success() {
        return status == ImportStatus.SUCCESS;
    }
}
