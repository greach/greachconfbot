package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents an audio file to be treated as music by the Telegram clients.
 * @see <a href="https://core.telegram.org/bots/api#audio">Audio</a>
 */
@Introspected
public class Audio {

    /**
     * Identifier for this file
     */
    @JsonProperty("file_id")
    @NotBlank
    @Nonnull
    private String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @JsonProperty("file_unique_id")
    @NotBlank
    @Nonnull
    private String fileUniqueId;

    /**
     * Duration of the audio in seconds as defined by sender
     */
    @Nonnull
    @NotNull
    private Integer duration;

    /**
     * Performer of the audio as defined by sender or by audio tags.
     */
    @Nullable
    private String performer;

    /**
     * Title of the audio as defined by sender or by audio tags.
     */
    @Nullable
    private String title;

    /**
     * MIME type of the file as defined by sender.
     */
    @Nullable
    @JsonProperty("mime_type")
    private String mimeType;

    @Nullable
    @JsonProperty("file_size")
    private Integer fileSize;

    /**
     * Thumbnail of the album cover to which the music file belongs.
     */
    @Nullable
    private PhotoSize thumb;

    public Audio() {
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
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(@Nullable String performer) {
        this.performer = performer;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
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

    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                '}';
    }
}
