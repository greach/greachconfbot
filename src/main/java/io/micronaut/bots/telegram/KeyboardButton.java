package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents one button of the reply keyboard. For simple text buttons String can be used instead of this object to specify text of the button. Optional fields request_contact, request_location, and request_poll are mutually exclusive.
 * @see <a href="https://core.telegram.org/bots/api#keyboardbutton">Keyboard Button</a>
 */
@Introspected
public class KeyboardButton {

    /**
     * Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
     */
    @NotBlank
    @Nonnull
    private String text;

    /**
     * If True, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
     */
    @Nullable
    @JsonProperty("request_contact")
    private Boolean requestContact;

    /**
     * If True, the user's current location will be sent when the button is pressed. Available in private chats only.
     */
    @Nullable
    @JsonProperty("request_location")
    private Boolean requestLocation;

    /**
     * If specified, the user will be asked to create a poll and send it to the bot when the button is pressed. Available in private chats only
     */
    @Nullable
    @JsonProperty("request_poll")
    private KeyboardButtonPollType requestPoll;

    public KeyboardButton() {
    }

    @Nonnull
    public String getText() {
        return text;
    }

    public void setText(@Nonnull String text) {
        this.text = text;
    }

    @Nullable
    public Boolean getRequestContact() {
        return requestContact;
    }

    public void setRequestContact(@Nullable Boolean requestContact) {
        this.requestContact = requestContact;
    }

    @Nullable
    public Boolean getRequestLocation() {
        return requestLocation;
    }

    public void setRequestLocation(@Nullable Boolean requestLocation) {
        this.requestLocation = requestLocation;
    }

    @Nullable
    public KeyboardButtonPollType getRequestPoll() {
        return requestPoll;
    }

    public void setRequestPoll(@Nullable KeyboardButtonPollType requestPoll) {
        this.requestPoll = requestPoll;
    }

    @Override
    public String toString() {
        return "KeyboardButton{" +
                "text='" + text + '\'' +
                ", requestContact=" + requestContact +
                ", requestLocation=" + requestLocation +
                ", requestPoll=" + (requestPoll != null ? requestPoll.toString() : "") +
                '}';
    }
}
