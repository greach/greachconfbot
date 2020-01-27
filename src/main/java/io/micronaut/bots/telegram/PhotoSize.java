package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents one size of a photo or a file / sticker thumbnail.
 * @see <a href="https://core.telegram.org/bots/api#photosize">PhotoSize</a>
 */
@Introspected
public class PhotoSize {

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
     * Photo width.
     */
    @Nonnull
    @NotNull
    private Integer width;

    /**
     * Photo height.
     */
    @Nonnull
    @NotNull
    private Integer height;

    /**
     * File size.
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

    public PhotoSize() {
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

    @Nullable
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "PhotoSize{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fileSize=" + fileSize +
                '}';
    }
}
