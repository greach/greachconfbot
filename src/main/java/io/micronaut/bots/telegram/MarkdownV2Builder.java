package io.micronaut.bots.telegram;

public class MarkdownV2Builder {

    public static final String PARSE_MODE_MARKDOWN_V2 = "MarkdownV2";

    String markdown = "";

    public MarkdownV2Builder() {

    }

    public MarkdownV2Builder newLine() {
        markdown += "\n";
        return this;
    }

    public MarkdownV2Builder bold(String text) {
        markdown += "*" + text + "*";
        return this;
    }

    public MarkdownV2Builder italic(String text) {
        markdown += "_" + text + "_";
        return this;
    }

    public MarkdownV2Builder underline(String text) {
        markdown += "__" + text + "__";
        return this;
    }

    public MarkdownV2Builder strikethrough(String text) {
        markdown += "~" + text + "~";
        return this;
    }

    public MarkdownV2Builder inlineUrl(String url, String text) {
        markdown += "[" + text + "](" + url + ")";
        return this;
    }

    public MarkdownV2Builder inlineMention(Integer userId, String text) {
        markdown += "[" + text + "](tg://user?id=" + userId + ")";
        return this;
    }

    public String build() {
        return markdown;
    }

    public MarkdownV2Builder text(String text) {
        markdown += text;
        return this;
    }
}
