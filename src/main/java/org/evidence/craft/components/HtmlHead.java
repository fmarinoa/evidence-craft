package org.evidence.craft.components;

public class HtmlHead {
    public static String createHead(String title) {
        return "<head>" +
                "<title>" + title + "</title>" +
                HtmlStyle.createStyle() +
                "</head>";
    }
}
