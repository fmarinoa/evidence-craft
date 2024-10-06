package org.evidence.craft;

import io.cucumber.java.Scenario;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class ReportGenerator {
    private String reportPath = "target/evidence-craft/";  // Ruta del archivo HTML
    private final List<String> screenshots;  // Lista para almacenar las capturas en Base64
    private final List<LocalDateTime> screenshotDateTime;  // Lista para almacenar las capturas en Base64

    public ReportGenerator() {
        this.screenshots = new ArrayList<>();
        this.screenshotDateTime = new ArrayList<>();
    }

    public ReportGenerator(String reportPath) {
        this();
        this.reportPath = reportPath;

    }

    // Método para capturar la pantalla y agregarla al reporte en una sola llamada
    public void captureAndAddScreenshot(byte[] screenshot) {
        String base64Image = java.util.Base64.getEncoder().encodeToString(screenshot);
        screenshotDateTime.add(LocalDateTime.now());
        screenshots.add("<img src='data:image/png;base64," + base64Image + "' alt='screenshot'/>");
    }

    // Método para generar el HTML y guardarlo en el archivo
    public void saveReport(Scenario scenario) throws IOException {
        createDirectory(new File(reportPath).getParentFile());

        writeToFile(new HtmlManager().createHtml(scenario, screenshots, screenshotDateTime),
                reportPath + scenario.getSourceTagNames() + ".html");
    }

    private void writeToFile(String content, String path) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(content.getBytes());
        }
    }

    private void createDirectory(File folder) throws IOException {
        if (!folder.exists()) {
            Files.createDirectories(Paths.get(folder.getAbsolutePath()));
        }
    }
}
