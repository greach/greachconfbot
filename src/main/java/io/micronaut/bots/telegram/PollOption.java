package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object contains information about one answer option in a poll.
 * @see <a href="https://core.telegram.org/bots/api#polloption">Poll Option</a>
 */
@Introspected
public class PollOption {
    /**
     * Option text, 1-100 characters.
     */
    @Nonnull
    @NotBlank
    private String text;

    /**
     * Number of users that voted for this option
     */
    @JsonProperty("voter_count")
    @Nonnull
    @NotNull
    private Integer voterCount;

    public PollOption() {
    }

    @Nonnull
    public String getText() {
        return text;
    }

    public void setText(@Nonnull String text) {
        this.text = text;
    }

    @Nonnull
    public Integer getVoterCount() {
        return voterCount;
    }

    public void setVoterCount(@Nonnull Integer voterCount) {
        this.voterCount = voterCount;
    }


    @Override
    public String toString() {
        return "PollOption{" +
                "text='" + text + '\'' +
                ", voterCount=" + voterCount +
                '}';
    }
}
