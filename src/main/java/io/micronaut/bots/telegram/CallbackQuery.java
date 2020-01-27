package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents an incoming callback query from a callback button in an inline keyboard. If the button that originated the query was attached to a message sent by the bot, the field message will be present. If the button was attached to a message sent via the bot (in inline mode), the field inline_message_id will be present. Exactly one of the fields data or game_short_name will be present..
 * @see <a href="https://core.telegram.org/bots/api#callbackquery">Callback Query</a>
 */
@Introspected
public class CallbackQuery {

    /**
     * Unique identifier for this query.
     */
    @Nonnull
    @NotBlank
    private String id;

    /**
     * Sender.
     */
    @Nonnull
    @NotNull
    @Valid
    private User from;

    /**
     * Message with the callback button that originated the query. Note that message content and message date will not be available if the message is too old
     */
    @Nullable
    private Message message;

    /**
     * Identifier of the message sent via the bot in inline mode, that originated the query.
     */
    @Nullable
    @JsonProperty("inline_message_id")
    private String inlineMessageId;

    /**
     * Global identifier, uniquely corresponding to the chat to which the message with the callback button was sent. Useful for high scores in games.
     */
    @Nonnull
    @NotBlank
    @JsonProperty("chat_instance")
    private String chatInstance;

    /**
     * Data associated with the callback button. Be aware that a bad client can send arbitrary data in this field.
     */
    @Nullable
    private String data;

    /**
     * Short name of a Game to be returned, serves as the unique identifier for the game.
     */
    @Nullable
    @JsonProperty("game_short_name")
    private String gameShortName;

    public CallbackQuery() {
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public void setId(@Nonnull String id) {
        this.id = id;
    }

    @Nonnull
    public User getFrom() {
        return from;
    }

    public void setFrom(@Nonnull User from) {
        this.from = from;
    }

    @Nullable
    public Message getMessage() {
        return message;
    }

    public void setMessage(@Nullable Message message) {
        this.message = message;
    }

    @Nullable
    public String getInlineMessageId() {
        return inlineMessageId;
    }

    public void setInlineMessageId(@Nullable String inlineMessageId) {
        this.inlineMessageId = inlineMessageId;
    }

    @Nonnull
    public String getChatInstance() {
        return chatInstance;
    }

    public void setChatInstance(@Nonnull String chatInstance) {
        this.chatInstance = chatInstance;
    }

    @Nullable
    public String getData() {
        return data;
    }

    public void setData(@Nullable String data) {
        this.data = data;
    }

    @Nullable
    public String getGameShortName() {
        return gameShortName;
    }

    public void setGameShortName(@Nullable String gameShortName) {
        this.gameShortName = gameShortName;
    }

    @Override
    public String toString() {
        return "CallbackQuery{" +
                "id='" + id + '\'' +
                ", from=" + (from != null ? from.toString() : "") +
                ", message=" + (message != null ? message.toString() : "") +
                ", inlineMessageId='" + inlineMessageId + '\'' +
                ", chatInstance='" + chatInstance + '\'' +
                ", data='" + data + '\'' +
                ", gameShortName='" + gameShortName + '\'' +
                '}';
    }
}
