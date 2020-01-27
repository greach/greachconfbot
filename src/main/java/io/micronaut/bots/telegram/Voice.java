package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a voice note.
 * @see <a href="https://core.telegram.org/bots/api#voice">Voice</a>
 */
@Introspected
public class Voice {
    /**
     * 	Identifier for this file.
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
     * Duration of the audio in seconds as defined by sender.
     */
    @Nonnull
    @NotNull
    private Integer	duration;

    /**
     * MIME type of the file as defined by sender.
     */
    @JsonProperty("mime_type")
    @Nullable
    private String mimeType;

    /**
     * File size
     */
    @Nullable
    @JsonProperty("file_size")
    private Integer	fileSize;

    public Voice() {
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
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@Nonnull Integer duration) {
        this.duration = duration;
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
        return "Voice{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
