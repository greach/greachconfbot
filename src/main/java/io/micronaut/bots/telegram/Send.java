package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

public abstract class Send {

    private final String method;

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * Integer or String
     */
    @JsonProperty("chat_id")
    @NotNull
    @Nonnull
    private Object chatId;

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @Nullable
    @JsonProperty("disable_notification")
    private Boolean disableNotification;

    /**
     * If the message is a reply, ID of the original message.
     */
    @Nullable
    @JsonProperty("reply_to_message_id")
    private String replyToMessageId;


    /**
     * additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     */
    @Nullable
    @JsonProperty("reply_markup")
    private String replyMarkup;

    public Send(String method) {
        this.method = method;
    }

    public Object getChatId() {
        return chatId;
    }

    public void setChatId(Object chatId) {
        this.chatId = chatId;
    }


    @Nullable
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(@Nullable Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    @Nullable
    public String getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(@Nullable String replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    @Nullable
    public String getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(@Nullable String replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
