package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class ForwardMessage {
    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername).
     */
    @JsonProperty("chat_id")
    @Nonnull
    @NotBlank
    private String chatId;

    /**
     * Unique identifier for the chat where the original message was sent (or channel username in the format @channelusername).
     */
    @JsonProperty("from_chat_id")
    @Nonnull
    @NotBlank
    private String fromChatId;

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    @Nullable
    private Boolean disableNotification;

    /**
     * Message identifier in the chat specified in from_chat_id
     */
    @JsonProperty("message_id")
    @Nonnull
    @NotNull
    private Integer messageId;

    public ForwardMessage() {
    }

    @Nonnull
    public String getChatId() {
        return chatId;
    }

    public void setChatId(@Nonnull String chatId) {
        this.chatId = chatId;
    }

    @Nonnull
    public String getFromChatId() {
        return fromChatId;
    }

    public void setFromChatId(@Nonnull String fromChatId) {
        this.fromChatId = fromChatId;
    }

    @Nullable
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(@Nullable Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    @Nonnull
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(@Nonnull Integer messageId) {
        this.messageId = messageId;
    }
}
