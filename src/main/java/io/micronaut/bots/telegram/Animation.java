package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents an animation file (GIF or H.264/MPEG-4 AVC video without sound).
 * @see <a href="https://core.telegram.org/bots/api#animation">Animation</a>
 */
@Introspected
public class Animation {

    /**
     * Identifier for this file
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
     * Video width as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer	width;

    /**
     * Video height as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer	height;

    /**
     * Duration of the video in seconds as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer	duration;

    /**
     * Animation thumbnail as defined by sender;
     */
    @Nullable
    @Valid
    private PhotoSize thumb;

    /**
     * Original animation filename as defined by sender.
     */
    @Nullable
    @JsonProperty("file_name")
    private String fileName;

    /**
     * MIME type of the file as defined by sender.
     */
    @Nullable
    @JsonProperty("mime_type")
    private String	mimeType;

    /**
     * File size.
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer	fileSize;

    public Animation() {
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
    public String getFileName() {
        return fileName;
    }

    public void setFileName(@Nullable String fileName) {
        this.fileName = fileName;
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
        return "Animation{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + (thumb !=null ? thumb.toString() : "") +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
