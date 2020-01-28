package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

@Introspected
public class AnswerCallbackQuery {

    /**
     * Unique identifier for the query to be answered.
     */
    @JsonProperty("callback_query_id")
    @Nonnull
    @NotBlank
    private String callbackQueryId;

    /**
     * Text of the notification. If not specified, nothing will be shown to the user, 0-200 characters,
     */
    @Nullable
    private String text;

    /**
     * If true, an alert will be shown by the client instead of a notification at the top of the chat screen. Defaults to false.
     */
    @Nullable
    @JsonProperty("show_alert")
    private Boolean showAlert;

    /**
     * URL that will be opened by the user's client. If you have created a Game and accepted the conditions via @Botfather, specify the URL that opens your game – note that this will only work if the query comes from a callback_game button.
     *
     * Otherwise, you may use links like t.me/your_bot?start=XXXX that open your bot with a parameter.
     */
    @Nullable
    private String url;

    /**
     * The maximum amount of time in seconds that the result of the callback query may be cached client-side. Telegram apps will support caching starting in version 3.14. Defaults to 0.
     */
    @JsonProperty("cache_time")
    @Nullable
    private Integer cacheTime;

    public AnswerCallbackQuery() {
    }

    public String getCallbackQueryId() {
        return callbackQueryId;
    }

    public void setCallbackQueryId(String callbackQueryId) {
        this.callbackQueryId = callbackQueryId;
    }

    @Nullable
    public String getText() {
        return text;
    }

    public void setText(@Nullable String text) {
        this.text = text;
    }

    @Nullable
    public Boolean getShowAlert() {
        return showAlert;
    }

    public void setShowAlert(@Nullable Boolean showAlert) {
        this.showAlert = showAlert;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public void setUrl(@Nullable String url) {
        this.url = url;
    }

    @Nullable
    public Integer getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(@Nullable Integer cacheTime) {
        this.cacheTime = cacheTime;
    }
}
