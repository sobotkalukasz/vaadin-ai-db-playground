package com.example.playground.importer.firstendpoint;

import com.example.playground.config.ExternalApiProperties;
import com.example.playground.importer.ExternalDataImporter;
import com.example.playground.importer.ImportRequest;
import com.example.playground.importer.ImportResult;
import com.example.playground.model.ImportStatus;
import com.example.playground.model.ImportedRecord;
import com.example.playground.repository.ImportedRecordRepository;
import java.time.Instant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FirstEndpointImporter implements ExternalDataImporter {

    public static final String NAME = "first-endpoint";

    private static final Logger log = LoggerFactory.getLogger(FirstEndpointImporter.class);

    private final ExternalApiProperties props;
    private final ImportedRecordRepository records;
    private final WebClient webClient;

    public FirstEndpointImporter(
            ExternalApiProperties props,
            ImportedRecordRepository records,
            WebClient.Builder builder) {
        this.props = props;
        this.records = records;
        this.webClient = builder.baseUrl(props.getBaseUrl()).build();
    }

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String displayName() {
        return cfg().getDisplayName();
    }

    @Override
    public String endpointPath() {
        return cfg().getPath();
    }

    @Override
    public ImportResult importData(ImportRequest request) {
        if (request.apiToken() == null || request.apiToken().isBlank()) {
            return new ImportResult(NAME, ImportStatus.FAILED, 0, "API token is required.");
        }

        log.info("Starting manual import for {} from {}", NAME, endpointPath());

        try {
            List<PlaceholderDto> items = fetch(request.apiToken());
            int saved = persist(items);
            return new ImportResult(NAME, ImportStatus.SUCCESS, saved, "Import completed.");
        } catch (Exception ex) {
            log.warn("Manual import failed for {}: {}", NAME, ex.getClass().getSimpleName());
            return new ImportResult(NAME, ImportStatus.FAILED, 0, "Import failed for first endpoint.");
        }
    }

    List<PlaceholderDto> fetch(String apiToken) {
        return webClient.get()
                .uri(endpointPath())
                .headers(headers -> headers.setBearerAuth(apiToken))
                .retrieve()
                .bodyToFlux(PlaceholderDto.class)
                .collectList()
                .block();
    }

    int persist(List<PlaceholderDto> items) {
        if (items == null) {
            return 0;
        }

        records.saveAll(items.stream()
                .map(item -> new ImportedRecord(
                        NAME,
                        item.id(),
                        item.title(),
                        item.updatedAt(),
                        item.rawJson()))
                .toList());
        return items.size();
    }

    private ExternalApiProperties.ImporterProperties cfg() {
        return props.getImporters().get(NAME);
    }

    record PlaceholderDto(String id, String title, Instant updatedAt, String rawJson) {}
}
