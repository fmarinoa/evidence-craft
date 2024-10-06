package org.evidence.craft.components;

public class HtmlBanner {
    public static String setStatusScenario(String name, String color) {
        return "<div class='status' style='background-color: " + color + ";' >" +
                "<h2 style='margin: 0;' >" + name + "</h2>" +
                "</div>";
    }
}
