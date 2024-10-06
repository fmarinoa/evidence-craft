package org.evidence.craft.components;

public class HtmlStyle {
    public static String createStyle() {
        return "<style>" +
                "body { font-family: Arial, sans-serif; margin: auto; }" +
                "h1 { color: #333; }" +
                "img { max-width: 100%; height: auto; }" +
                ".status {width: 100%; padding-bottom: 5; padding-top: 5; text-align: center;color: white;margin: 0; }" +
                ".evidence {padding: 5;}" +
                ".title {padding: 10px 5px;}" +
                "</style>";
    }
}
