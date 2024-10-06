package org.evidence.craft;

import io.cucumber.java.Scenario;
import org.evidence.craft.components.HtmlBanner;
import org.evidence.craft.components.HtmlBody;
import org.evidence.craft.components.HtmlHead;
import org.evidence.craft.components.HtmlImg;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HtmlManager {

    public String createHtml(Scenario scenario, List<String> screenshots, List<LocalDateTime> times) {
        StringBuilder htmlContent = new StringBuilder();

        htmlContent.append("<html>");

        htmlContent.append(HtmlHead.createHead("Test Report - Evidence Craft"));

        htmlContent.append("<body>");

        boolean isScenarioFailed = scenario.isFailed();
        htmlContent.append(HtmlBanner.setStatusScenario(
                isScenarioFailed ? "Escenario Fallido" : "Escenario Exitoso" +
                        " - " +
                        new TimeCalculator().calculateTimelap(times),
                isScenarioFailed ? "#b00" : "#2cb14a"));

        htmlContent.append(HtmlBody.createTitle(scenario));

        addedImgsInHtml(htmlContent, screenshots, times);

        htmlContent.append("</body>").append("</html>");

        return htmlContent.toString();
    }

    private void addedImgsInHtml(StringBuilder htmlContent, List<String> screenshots, List<LocalDateTime> times) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

        for (int i = 0; i < screenshots.size(); i++) {
            htmlContent.append(HtmlImg.addScreenshot(screenshots.get(i), times.get(i).format(formatter)));
        }
    }
}
