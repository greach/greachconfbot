package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents an inline keyboard that appears right next to the message it belongs to.
 * @see <a href="https://core.telegram.org/bots/api#inlinekeyboardmarkup">InlineKeyboardMarkup</a>
 */
@Introspected
public class InlineKeyboardMarkup {
    /**
     * Array of button rows, each represented by an Array of InlineKeyboardButton objects.
     */
    @Nonnull
    @NotNull
    @JsonProperty("inline_keyboard")
    private List<List<InlineKeyboardButton>> inlineKeyboard;

    public InlineKeyboardMarkup() {
    }

    @Nonnull
    public List<List<InlineKeyboardButton>>  getInlineKeyboard() {
        return inlineKeyboard;
    }

    public void setInlineKeyboard(@Nonnull List<List<InlineKeyboardButton>>  inlineKeyboard) {
        this.inlineKeyboard = inlineKeyboard;
    }

    @Override
    public String toString() {
        return "InlineKeyboardMarkup{" +
                "inlineKeyboard=" + (inlineKeyboard != null ? String.join(",", inlineKeyboard.stream().map(keyboard -> String.join(",", keyboard.stream().map(InlineKeyboardButton::toString).collect(Collectors.toList()))).collect(Collectors.toList())) : "") +
                '}';
    }
}
