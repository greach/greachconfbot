package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nullable;

/**
 * Contains information about why a request was unsuccessful.
 * @see <a href="https://core.telegram.org/bots/api#responseparameters">ResponseParameters</a>
 */
@Introspected
public class ResponseParameters {
    /**
     * The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @Nullable
    @JsonProperty("migrate_to_chat_id")
    private Integer migrateToChatId;

    /**
     * In case of exceeding flood control, the number of seconds left to wait before the request can be repeated
     */
    @Nullable
    @JsonProperty("retry_after")
    private Integer retryAfter;

    public ResponseParameters() {
    }

    @Nullable
    public Integer getMigrateToChatId() {
        return migrateToChatId;
    }

    public void setMigrateToChatId(@Nullable Integer migrateToChatId) {
        this.migrateToChatId = migrateToChatId;
    }

    @Nullable
    public Integer getRetryAfter() {
        return retryAfter;
    }

    public void setRetryAfter(@Nullable Integer retryAfter) {
        this.retryAfter = retryAfter;
    }

    @Override
    public String toString() {
        return "ResponseParameters{" +
                "migrateToChatId=" + migrateToChatId +
                ", retryAfter=" + retryAfter +
                '}';
    }
}


