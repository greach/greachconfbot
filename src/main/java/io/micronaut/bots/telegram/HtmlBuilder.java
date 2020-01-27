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
}
