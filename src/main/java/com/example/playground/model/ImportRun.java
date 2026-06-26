package com.example.playground.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

@Entity
public class ImportRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String importerName;

    @Enumerated(EnumType.STRING)
    private ImportStatus status;

    private int importedCount;
    private String sanitizedMessage;
    private Instant startedAt;
    private Instant finishedAt;

    protected ImportRun() {}

    public ImportRun(String importerName) {
        this.importerName = importerName;
        this.startedAt = Instant.now();
    }

    public void complete(ImportStatus status, int importedCount, String sanitizedMessage) {
        this.status = status;
        this.importedCount = importedCount;
        this.sanitizedMessage = sanitizedMessage;
        this.finishedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public String getImporterName() {
        return importerName;
    }

    public ImportStatus getStatus() {
        return status;
    }

    public int getImportedCount() {
        return importedCount;
    }

    public String getSanitizedMessage() {
        return sanitizedMessage;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public Instant getFinishedAt() {
        return finishedAt;
    }
}
