package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a custom keyboard with reply options (see Introduction to bots for details and examples).
 * @see <a href="https://core.telegram.org/bots/api#replykeyboardmarkup">ReplyKeyboardMarkup</a>
 */
@Introspected
public class ReplyKeyboardMarkup {

    /**
     * Array of button rows, each represented by an Array of KeyboardButton objects
     */
    @Nonnull
    @NotNull
    private List<KeyboardButton> keyboard;

    /**
     * Requests clients to resize the keyboard vertically for optimal fit (e.g., make the keyboard smaller if there are just two rows of buttons). Defaults to false, in which case the custom keyboard is always of the same height as the app's standard keyboard.
     */
    @Nullable
    @JsonProperty("resize_keyboard")
    private Boolean resizeKeyboard;

    /**
     * Requests clients to hide the keyboard as soon as it's been used. The keyboard will still be available, but clients will automatically display the usual letter-keyboard in the chat – the user can press a special button in the input field to see the custom keyboard again. Defaults to false.
     */
    @Nullable
    @JsonProperty("one_time_keyboard")
    private Boolean oneTimeKeyboard;

    /**
     * Use this parameter if you want to show the keyboard to specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     * Example: A user requests to change the bot‘s language, bot replies to the request with a keyboard to select the new language. Other users in the group don’t see the keyboard.
     */
    @Nullable
    private Boolean selective;

    public ReplyKeyboardMarkup() {
    }

    @Nonnull
    public List<KeyboardButton> getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(@Nonnull List<KeyboardButton> keyboard) {
        this.keyboard = keyboard;
    }

    @Nullable
    public Boolean getResizeKeyboard() {
        return resizeKeyboard;
    }

    public void setResizeKeyboard(@Nullable Boolean resizeKeyboard) {
        this.resizeKeyboard = resizeKeyboard;
    }

    @Nullable
    public Boolean getOneTimeKeyboard() {
        return oneTimeKeyboard;
    }

    public void setOneTimeKeyboard(@Nullable Boolean oneTimeKeyboard) {
        this.oneTimeKeyboard = oneTimeKeyboard;
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
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + (keyboard != null ?  String.join(",",keyboard.stream().map(KeyboardButton::toString).collect(Collectors.toList())) : "") +
                ", resizeKeyboard=" + resizeKeyboard +
                ", oneTimeKeyboard=" + oneTimeKeyboard +
                ", selective=" + selective +
                '}';
    }
}
