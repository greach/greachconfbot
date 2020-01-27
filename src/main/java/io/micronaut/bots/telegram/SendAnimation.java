package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

@Introspected
public class SendAnimation extends Send {

    /**
     * Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), pass an HTTP URL as a String for Telegram to get an animation from the Internet, or upload a new animation using multipart/form-data.
     */
    @Nonnull
    @NotBlank
    private String animation;

    /**
     * Duration of sent video in seconds
     */
    @Nullable
    private Integer duration;

    /**
     * Video width.
     */
    @Nullable
    private Integer width;

    /**
     * Video height.
     */
    @Nullable
    private Integer height;

    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side. The thumbnail should be in JPEG format and less than 200 kB in size. A thumbnail‘s width and height should not exceed 320. Ignored if the file is not uploaded using multipart/form-data. Thumbnails can’t be reused and can be only uploaded as a new file, so you can pass “attach://<file_attach_name>” if the thumbnail was uploaded using multipart/form-data under <file_attach_name>.
     * @see <a href="https://core.telegram.org/bots/api#sending-files">More info on Sending Files</a>
     */
    @Nullable
    private String thumb;

    /**
     * Photo caption (may also be used when resending photos by file_id), 0-1024 characters.
     */
    @Nullable
    private String caption;

    /**
     * Send Markdown or HTML, if you want Telegram apps to show bold, italic, fixed-width text or inline URLs in the media caption.
     */
    @JsonProperty("parse_mode")
    @Nullable
    private String parseMode;


    public SendAnimation() {
        super("sendAnimation");
    }

    @Nonnull
    public String getAnimation() {
        return animation;
    }

    public void setAnimation(@Nonnull String animation) {
        this.animation = animation;
    }

    @Nullable
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public void setWidth(@Nullable Integer width) {
        this.width = width;
    }

    @Nullable
    public Integer getHeight() {
        return height;
    }

    public void setHeight(@Nullable Integer height) {
        this.height = height;
    }

    @Nullable
    public String getThumb() {
        return thumb;
    }

    public void setThumb(@Nullable String thumb) {
        this.thumb = thumb;
    }

    @Nullable
    public String getCaption() {
        return caption;
    }

    public void setCaption(@Nullable String caption) {
        this.caption = caption;
    }

    @Nullable
    public String getParseMode() {
        return parseMode;
    }

    public void setParseMode(@Nullable String parseMode) {
        this.parseMode = parseMode;
    }


}
