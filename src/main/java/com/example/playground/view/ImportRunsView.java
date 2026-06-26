package com.example.playground.view;

import com.example.playground.model.ImportRun;
import com.example.playground.repository.ImportRunRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Route;

@Route(value = "import-runs", layout = MainLayout.class)
public class ImportRunsView extends Main {

    public ImportRunsView(ImportRunRepository repo) {
        Grid<ImportRun> grid = new Grid<>(ImportRun.class, false);
        grid.addColumns(
                "id",
                "importerName",
                "status",
                "importedCount",
                "sanitizedMessage",
                "startedAt",
                "finishedAt");
        grid.setItems(repo.findAll());
        add(grid);
    }
}
