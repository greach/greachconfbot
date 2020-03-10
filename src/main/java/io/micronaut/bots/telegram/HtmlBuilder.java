package io.micronaut.bots.telegram;

public class HtmlBuilder {

    String html = "";


    public String build() {
        return html;
    }

    public HtmlBuilder bold(String text) {
        html += "<b>" + text + "</b>";
        return this;
    }

    public HtmlBuilder newLine() {
        html += "\n";
        return this;
    }

    public HtmlBuilder text(String text) {
        html += text;
        return this;
    }

    public static String cleanupUnsupportedHtmlTags(String text) {
        String result = text;
        for (String tag : HtmlStyle.HTML_TAGS) {
            if (HtmlStyle.TELEGRAM_SUPPORTED_TAGS.contains(tag)) {
                continue;
            }
            result = result.replaceAll("<" + tag + ">", "").replaceAll("</" + tag + ">", "");
        }
        return result;
    }
}
