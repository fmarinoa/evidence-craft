package org.evidence.craft.components;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HtmlImg {
    public static String addScreenshot(String screenShot, String time) {
        return "<div class='evidence'>" +
                time +
                screenShot +
                "</div>";
    }
}