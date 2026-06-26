package com.example.playground.view;

import com.example.playground.importer.ExternalDataImporter;
import com.example.playground.importer.ImportOrchestrator;
import com.example.playground.importer.ImportRequest;
import com.example.playground.importer.ImportResult;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.Route;

@Route(value = "manual-import", layout = MainLayout.class)
public class ManualImportView extends Main {

    public ManualImportView(ImportOrchestrator orchestrator) {
        ComboBox<ExternalDataImporter> selector = new ComboBox<>("Endpoint/importer");
        selector.setItems(orchestrator.availableImporters());
        selector.setItemLabelGenerator(importer -> importer.displayName() + " (" + importer.endpointPath() + ")");

        PasswordField token = new PasswordField("API key/token");
        token.setRevealButtonVisible(false);

        Button run = new Button("Run import", event -> {
            ExternalDataImporter importer = selector.getValue();
            if (importer == null || token.isEmpty()) {
                Notification.show("Select an importer and enter an API token.");
                return;
            }

            ImportResult result = orchestrator.run(new ImportRequest(importer.name(), token.getValue()));
            token.clear();
            Notification.show(result.sanitizedMessage() + " Imported: " + result.importedCount());
        });

        add(selector, token, run);
    }
}
