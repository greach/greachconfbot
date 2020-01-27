package io.micronaut.bots.telegram;

public enum ParseMode {

    MARKDOWN("Markdown"), HTML("HTML");

    private String value;
    ParseMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
