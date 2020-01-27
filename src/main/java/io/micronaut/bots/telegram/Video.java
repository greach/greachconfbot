package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a video file.
 * @see <a href="https://core.telegram.org/bots/api#video">Video</a>
 */
@Introspected
public class Video {

    /**
     * Identifier for this file.
     */
    @JsonProperty("file_id")
    @Nonnull
    @NotBlank
    private String fileId;

    /**
     * Video width as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer width;

    /**
     * Video height as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer height;

    /**
     * Duration of the video in seconds as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer duration;

    /**
     * Video thumbnail
     */
    @Nullable
    @Valid
    private PhotoSize thumb;

    /**
     * Mime type of a file as defined by sender.
     */
    @Nullable
    @JsonProperty("mime_type")
    private String mimeType;

    /**
     * File size.
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer fileSize;

    public Video() {
    }

    @Nonnull
    public String getFileId() {
        return fileId;
    }

    public void setFileId(@Nonnull String fileId) {
        this.fileId = fileId;
    }

    @Nonnull
    public Integer getWidth() {
        return width;
    }

    public void setWidth(@Nonnull Integer width) {
        this.width = width;
    }

    @Nonnull
    public Integer getHeight() {
        return height;
    }

    public void setHeight(@Nonnull Integer height) {
        this.height = height;
    }

    @Nonnull
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@Nonnull Integer duration) {
        this.duration = duration;
    }

    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    @Nullable
    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(@Nullable String mimeType) {
        this.mimeType = mimeType;
    }

    @Nullable
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "Video{" +
                "fileId='" + fileId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
