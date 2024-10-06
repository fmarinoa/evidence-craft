package org.evidence.craft.components;

import io.cucumber.java.Scenario;

public class HtmlBody {
    public static String createTitle(Scenario scenario) {
        return "<div class='title'>" +
                "<p style='margin:0;'>" + String.valueOf(scenario.getSourceTagNames()).replace("[", "").replace("]", "") + "</p>" +
                "<h1 style='margin:0;'>Escenario: " + scenario.getName() + "</h1>" +
                "</div>";
    }

}
