package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nullable;

/**
 * Represents a photo to be sent.
 */
@Introspected
public class InputMediaPhoto extends InputMedia {

    public static final String TYPE_PHOTO = "photo";


    public InputMediaPhoto() {
        super(TYPE_PHOTO);
    }

    @Override
    public String toString() {
        return "InputMediaPhoto{"+
                super.toString() +
                "}";
    }
}
