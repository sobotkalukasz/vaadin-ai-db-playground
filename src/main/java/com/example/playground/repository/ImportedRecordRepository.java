package com.example.playground.repository;

import com.example.playground.model.ImportedRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportedRecordRepository extends JpaRepository<ImportedRecord, Long> {}
