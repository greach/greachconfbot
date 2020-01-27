package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a sticker.
 */
@Introspected
public class Sticker {
    /**
     * Identifier for this file, which can be used to download or reuse the file
     */
    @Nonnull
    @NotBlank
    @JsonProperty("file_id")
    private String fileId;

    /**
     * Unique identifier for this file, which is supposed to be the same over time and for different bots. Can't be used to download or reuse the file.
     */
    @Nonnull
    @NotBlank
    @JsonProperty("file_unique_id")
    private String fileUniqueId;

    /**
     * Sticker width
     */
    @Nonnull
    @NotNull
    private Integer width;

    /**
     * Sticker height
     */
    @Nonnull
    @NotNull
    private Integer height;

    /**
     * True, if the sticker is animated
     */
    @JsonProperty("is_animated")
    @Nonnull
    @NotNull
    private Boolean isAnimated;

    /**
     * Sticker thumbnail in the .webp or .jpg format.
     */
    @Nullable
    private PhotoSize thumb;

    /**
     * Emoji associated with the sticker
     */
    @Nullable
    private String emoji;

    /**
     * Name of the sticker set to which the sticker belongs
     */
    @Nullable
    @JsonProperty("set_name")
    private String setName;

    /**
     * For mask stickers, the position where the mask should be placed
     */
    @Nullable
    @JsonProperty("mask_position")
    private MaskPosition maskPosition;

    /**
     * File size
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

    public Sticker() {
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
    public Boolean getAnimated() {
        return isAnimated;
    }

    public void setAnimated(@Nonnull Boolean animated) {
        isAnimated = animated;
    }

    @Nullable
    public PhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(@Nullable PhotoSize thumb) {
        this.thumb = thumb;
    }

    @Nullable
    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(@Nullable String emoji) {
        this.emoji = emoji;
    }

    @Nullable
    public String getSetName() {
        return setName;
    }

    public void setSetName(@Nullable String setName) {
        this.setName = setName;
    }

    @Nullable
    public MaskPosition getMaskPosition() {
        return maskPosition;
    }

    public void setMaskPosition(@Nullable MaskPosition maskPosition) {
        this.maskPosition = maskPosition;
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
        return "Sticker{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", isAnimated=" + isAnimated +
                ", thumb=" + (thumb != null ? thumb.toString() : "") +
                ", emoji='" + emoji  + '\'' +
                ", setName='" + setName + '\'' +
                ", maskPosition=" + (maskPosition != null ? maskPosition.toString() : "") +
                ", fileSize=" + fileSize +
                '}';
    }
}
