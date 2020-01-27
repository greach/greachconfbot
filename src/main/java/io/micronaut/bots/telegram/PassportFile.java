package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;

/**
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.
 * @see <a href="https://core.telegram.org/bots/api#passportfile">PassportFile</a>
 */
@Introspected
public class PassportFile {
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
     * File size
     */
    @JsonProperty("file_size;")
    private Integer fileSize;


    /**
     * Unix time when the file was uploaded
     */
    @JsonProperty("file_date;")
    private Integer fileDate;

    public PassportFile() {
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

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public Integer getFileDate() {
        return fileDate;
    }

    public void setFileDate(Integer fileDate) {
        this.fileDate = fileDate;
    }

    @Override
    public String toString() {
        return "PassportFile{" +
                "fileId='" + fileId + '\'' +
                ", fileUniqueId='" + fileUniqueId + '\'' +
                ", fileSize=" + fileSize +
                ", fileDate=" + fileDate +
                '}';
    }
}
