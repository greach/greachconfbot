package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object contains information about a poll.
 * @see <a href="https://core.telegram.org/bots/api#poll">Poll</a>
 */
@Introspected
public class Poll {

    /**
     * Unique poll identifier;
     */
    @Nonnull
    @NotBlank
    private String id;

    /**
     * Poll question, 1-255 characters
     */
    @Nonnull
    @NotBlank
    private String question;

    /**
     * List of poll options
     */
    @Nonnull
    @NotNull
    private List<PollOption> options;

    /**
     * Total number of users that voted in the poll.
     */
    @JsonProperty("total_voter_count")
    @Nonnull
    @NotNull
    private Integer totalVoterCount;

    /**
     * True, if the poll is closed.
     */
    @JsonProperty("is_closed")
    @Nonnull
    @NotNull
    private Boolean isClosed;

    /**
     * True, if the poll is anonymous
     */
    @JsonProperty("is_anonymous")
    @Nonnull
    @NotNull
    private Boolean isAnonymous;

    /**
     * type, currently can be “regular” or “quiz”
     */
    @Nonnull
    @NotBlank
    @Pattern(regexp = "regular|quiz")
    private String typePoll;

    /**
     * True, if the poll allows multiple answers
     */
    @JsonProperty("allows_multiple_answers")
    @Nonnull
    @NotNull
    private Boolean allowsMultipleAnswers;

    /**
     * Optional. 0-based identifier of the correct answer option. Available only for polls in the quiz mode, which are closed, or was sent (not forwarded) by the bot or to the private chat with the bot.
     */
    @JsonProperty("correct_option_id")
    private Integer correctOptionId;

    public Poll() {
    }

    @Nonnull
    public String getId() {
        return id;
    }

    public void setId(@Nonnull String id) {
        this.id = id;
    }

    @Nonnull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@Nonnull String question) {
        this.question = question;
    }

    @Nonnull
    public List<PollOption> getOptions() {
        return options;
    }

    public void setOptions(@Nonnull List<PollOption> options) {
        this.options = options;
    }

    @Nonnull
    public Integer getTotalVoterCount() {
        return totalVoterCount;
    }

    public void setTotalVoterCount(@Nonnull Integer totalVoterCount) {
        this.totalVoterCount = totalVoterCount;
    }

    @Nonnull
    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(@Nonnull Boolean closed) {
        isClosed = closed;
    }

    @Nonnull
    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(@Nonnull Boolean anonymous) {
        isAnonymous = anonymous;
    }

    @Nonnull
    public String getTypePoll() {
        return typePoll;
    }

    public void setTypePoll(@Nonnull String typePoll) {
        this.typePoll = typePoll;
    }

    @Nonnull
    public Boolean getAllowsMultipleAnswers() {
        return allowsMultipleAnswers;
    }

    public void setAllowsMultipleAnswers(@Nonnull Boolean allowsMultipleAnswers) {
        this.allowsMultipleAnswers = allowsMultipleAnswers;
    }

    public Integer getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(Integer correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    @Override
    public String toString() {
        return "Poll{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", options=" + (options != null ?  String.join(",",options.stream().map(PollOption::toString).collect(Collectors.toList())) : "") +
                ", totalVoterCount=" + totalVoterCount +
                ", isClosed=" + isClosed +
                ", isAnonymous=" + isAnonymous +
                ", typePoll='" + typePoll + '\'' +
                ", allowsMultipleAnswers=" + allowsMultipleAnswers +
                ", correctOptionId=" + correctOptionId +
                '}';
    }
}
