package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link https://api.telegram.org/file/bot<token>/<file_path>. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling getFile.
 * @see <a href="https://core.telegram.org/bots/api#file">File</a>
 */
@Introspected
public class File {
    /**
     * Identifier for this file, which can be used to download or reuse the file.
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
     * File size, if known.
     */
    @JsonProperty("file_size")
    @Nullable
    private Integer fileSize;

    /**
     * File path. Use https://api.telegram.org/file/bot<token>/<file_path> to get the file.
     */
    @Nullable
    @JsonProperty("file_path")
    private String filePath;

    public File() {
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

    @Nullable
    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(@Nullable Integer fileSize) {
        this.fileSize = fileSize;
    }

    @Nullable
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(@Nullable String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", fileSize=" + fileSize +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
