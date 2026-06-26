package com.example.playground.view;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
public class HomeView extends Main {

    public HomeView() {
        add(
                new H2("Playground for Vaadin 25.2 AI preview features"),
                new Paragraph("Use manual imports to populate PostgreSQL before adding AI-powered exploration views."));
    }
}
