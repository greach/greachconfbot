package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendmessage">sendMessage</a>
 */
@Introspected
public class SendMessage extends Send {

    @NotBlank
    private String method = "sendMessage";

    /**
     * Text of the message to be sent
     */
    @Nonnull
    @NotBlank
    private String text;

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    @Nullable
    private String parseMode;

    /**
     * Disables link previews for links in this message.
     */
    @Nullable
    @JsonProperty("disable_web_page_preview")
    private Boolean disableWebPagePreview;

    public SendMessage() {
        super("sendMessage");
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Nullable
    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(@Nullable String parseMode) {
        this.parseMode = parseMode;
    }

    @Nullable
    public Boolean getDisableWebPagePreview() {
        return disableWebPagePreview;
    }

    public void setDisableWebPagePreview(@Nullable Boolean disableWebPagePreview) {
        this.disableWebPagePreview = disableWebPagePreview;
    }

}