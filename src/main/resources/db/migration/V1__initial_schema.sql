CREATE TABLE import_run (id BIGSERIAL PRIMARY KEY, importer_name VARCHAR(255) NOT NULL, status VARCHAR(32), imported_count INTEGER NOT NULL DEFAULT 0, sanitized_message VARCHAR(1024), started_at TIMESTAMPTZ NOT NULL, finished_at TIMESTAMPTZ);
CREATE TABLE imported_record (id BIGSERIAL PRIMARY KEY, importer_name VARCHAR(255) NOT NULL, external_id VARCHAR(255), title VARCHAR(1024), source_updated_at TIMESTAMPTZ, raw_payload JSONB, imported_at TIMESTAMPTZ NOT NULL DEFAULT NOW());
CREATE INDEX idx_imported_record_importer ON imported_record(importer_name);
