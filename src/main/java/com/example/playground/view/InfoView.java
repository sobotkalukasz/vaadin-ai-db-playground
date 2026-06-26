package com.example.playground.view;
import com.vaadin.flow.component.html.*; import com.vaadin.flow.router.*; import org.springframework.beans.factory.annotation.Value;
@Route(value="info", layout=MainLayout.class) public class InfoView extends Main { public InfoView(@Value("${spring.application.name:vaadin-ai-db-playground}") String app,@Value("${project.version:0.0.1-SNAPSHOT}") String version){ add(new H2("Health / Info"), new Paragraph("Application: "+app), new Paragraph("Version: "+version), new Paragraph("Java: "+System.getProperty("java.version"))); }}
