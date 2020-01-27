package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

@Introspected
public class SendVideoNote extends Send {

    /**
     * Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended) or upload a new video using multipart/form-data.
     */
    @JsonProperty("video_note")
    @Nonnull
    @NotBlank
    private String videoNote;

    /**
     * Duration of sent video in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Video width and height, i.e. diameter of the video message.
     */
    @Nullable
    private Integer length;

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @see <a href="https://core.telegram.org/bots/api#sending-files">More info on Sending Files</a>
     */
    @Nullable
    private String thumb;
    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @JsonProperty("disable_notification")
    @Nullable
    private Boolean disableNotification;


    public SendVideoNote() {
        super("sendVideoNote");
    }

    @Nonnull
    public String getVideoNote() {
        return videoNote;
    }

    public void setVideoNote(@Nonnull String videoNote) {
        this.videoNote = videoNote;
    }

    @Nullable
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    @Nullable
    public Integer getLength() {
        return length;
    }

    public void setLength(@Nullable Integer length) {
        this.length = length;
    }

    @Nullable
    public String getThumb() {
        return thumb;
    }

    public void setThumb(@Nullable String thumb) {
        this.thumb = thumb;
    }

    @Override
    @Nullable
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    @Override
    public void setDisableNotification(@Nullable Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }
}
