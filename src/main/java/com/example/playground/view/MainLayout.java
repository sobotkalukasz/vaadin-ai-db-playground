package com.example.playground.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        addToNavbar(new DrawerToggle(), new H1("Vaadin AI DB Playground"));
        addToDrawer(new VerticalLayout(
                new RouterLink("Home", HomeView.class),
                new RouterLink("Info", InfoView.class),
                new RouterLink("Manual Import", ManualImportView.class),
                new RouterLink("Import Runs", ImportRunsView.class),
                new RouterLink("Imported Records", ImportedRecordsView.class)));
    }
}
