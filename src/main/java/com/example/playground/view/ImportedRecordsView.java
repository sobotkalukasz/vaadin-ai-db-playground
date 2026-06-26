package com.example.playground.view;

import com.example.playground.model.ImportedRecord;
import com.example.playground.repository.ImportedRecordRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Route;

@Route(value = "records", layout = MainLayout.class)
public class ImportedRecordsView extends Main {

    public ImportedRecordsView(ImportedRecordRepository repo) {
        Grid<ImportedRecord> grid = new Grid<>(ImportedRecord.class, false);
        grid.addColumns("id", "importerName", "externalId", "title", "sourceUpdatedAt", "importedAt");
        grid.setItems(repo.findAll());
        add(grid);
    }
}
