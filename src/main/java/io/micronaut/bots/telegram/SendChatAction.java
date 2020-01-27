package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;

@Introspected
public class SendChatAction extends Send {

    /**
     * Type of action to broadcast. Choose one, depending on what the user is about to receive: typing for text messages, upload_photo for photos, record_video or upload_video for videos, record_audio or upload_audio for audio files, upload_document for general files, find_location for location data, record_video_note or upload_video_note for video notes.
     */
    @NotBlank
    @Nonnull
    private String action;

    public SendChatAction() {
        super("sendChatAction");
    }

    @Nonnull
    public String getAction() {
        return action;
    }

    public void setAction(@Nonnull String action) {
        this.action = action;
    }
}
