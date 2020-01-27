package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a video message (available in Telegram apps as of v.4.0).
 * @see <a href="https://core.telegram.org/bots/api#videonote">VideoNote</a>
 */
@Introspected
public class VideoNote {

    /**
     * Identifier for this file.
     */
    @JsonProperty("file_id")
    @Nonnull
    @NotBlank
    private String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @JsonProperty("file_unique_id")
    @Nonnull
    @NotBlank
    private String fileUniqueId;

    /**
     * Video width and height (diameter of the video message) as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer length;

    /**
     * Duration of the video in seconds as defined by sender.
     */
    @Nonnull
    @NotNull
    private Integer	duration;

    /**
     * Video thumbnail
     */
    @Nullable
    @Valid
    private PhotoSize thumb;

    /**
     * File size.
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer	fileSize;

    public VideoNote() {

    }

    @Nonnull
    public String getFileId() {
        return fileId;
    }

    public void setFileId(@Nonnull String fileId) {
        this.fileId = fileId;
    }

    @Nonnull
    public String getFileUniqueId() {
        return fileUniqueId;
    }

    public void setFileUniqueId(@Nonnull String fileUniqueId) {
        this.fileUniqueId = fileUniqueId;
    }

    @Nonnull
    public Integer getLength() {
        return length;
    }

    public void setLength(@Nonnull Integer length) {
        this.length = length;
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
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "VideoNote{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", length=" + length +
                ", duration=" + duration +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", fileSize=" + fileSize +
                '}';
    }
}
