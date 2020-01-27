package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * Upon receiving a message with this object, Telegram clients will remove the current custom keyboard and display the default letter-keyboard. By default, custom keyboards are displayed until a new keyboard is sent by a bot. An exception is made for one-time keyboards that are hidden immediately after the user presses a button (see ReplyKeyboardMarkup).
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardremove">ReplyKeyboardRemove</a>
 */
@Introspected
public class ReplyKeyboardRemove {
    /**
     * Requests clients to remove the custom keyboard (user will not be able to summon this keyboard; if you want to hide the keyboard from sight but keep it accessible, use one_time_keyboard in ReplyKeyboardMarkup)
     */
    @JsonProperty("remove_keyboard")
    @Nonnull
    @NotNull
    private Boolean removeKeyboard = Boolean.TRUE;

    /**
     * Use this parameter if you want to remove the keyboard for specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    @Nullable
    private Boolean selective;

    public ReplyKeyboardRemove() {
    }

    @Nonnull
    public Boolean getRemoveKeyboard() {
        return removeKeyboard;
    }

    public void setRemoveKeyboard(@Nonnull Boolean removeKeyboard) {
        this.removeKeyboard = removeKeyboard;
    }

    @Nullable
    public Boolean getSelective() {
        return selective;
    }

    public void setSelective(@Nullable Boolean selective) {
        this.selective = selective;
    }

    @Override
    public String toString() {
        return "ReplyKeyboardRemove{" +
                "removeKeyboard=" + removeKeyboard +
                ", selective=" + selective +
                '}';
    }
}
