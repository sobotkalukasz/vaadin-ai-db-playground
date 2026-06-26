package com.example.playground.ui;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
        addClassNames(LumoUtility.Padding.LARGE, LumoUtility.TextAlignment.CENTER);

        add(
                new H1("Vaadin AI DB Playground"),
                new Paragraph("A starting point for experimenting with Vaadin views, AI workflows, and database-backed features.")
        );
    }
}
