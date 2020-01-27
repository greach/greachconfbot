package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nullable;

/**
 * This object represents type of a poll, which is allowed to be created and sent when the corresponding button is pressed.
 * @see <a href="https://core.telegram.org/bots/api#keyboardbuttonpolltype">KeybaordButtonPollType</a>.
 */
@Introspected
public class KeyboardButtonPollType {

    /**
     * If quiz is passed, the user will be allowed to create only polls in the quiz mode. If regular is passed, only regular polls will be allowed. Otherwise, the user will be allowed to create a poll of any type.
     */
    @Nullable
    private String type;

    public KeyboardButtonPollType() {
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "KeyboardButtonPollType{" +
                "type='" + type + '\'' +
                '}';
    }
}
