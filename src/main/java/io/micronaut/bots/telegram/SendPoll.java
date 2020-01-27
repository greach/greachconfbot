package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Introspected
public class SendPoll extends Send {

    /**
     * Poll question, 1-255 characters.
     */
    @Nonnull
    @NotBlank
    private String question;

    /**
     * List of answer options, 2-10 strings 1-100 characters each
     */
    @Nonnull
    @NotNull
    private List<String> options;

    /**
     * True, if the poll needs to be anonymous, defaults to True.
     */
    @JsonProperty("is_anonymous")
    @Nullable
    private Boolean isAnonymous;

    /**
     * Poll type, “quiz” or “regular”, defaults to “regular”.
     */
    @Nullable
    private String type;

    /**
     * True, if the poll allows multiple answers, ignored for polls in quiz mode, defaults to False.
     */
    @Nullable
    @JsonProperty("allows_multiple_answers")
    private Boolean allowsMultipleAnswers;

    /**
     * 0-based identifier of the correct answer option, required for polls in quiz mode.
     */
    @Nullable
    @JsonProperty("correct_option_id")
    private Integer correctOptionId;

    /**
     * Pass True, if the poll needs to be immediately closed.
     */
    @Nullable
    @JsonProperty("is_closed")
    private Boolean isClosed;

    public SendPoll() {
        super("sendPoll");
    }

    @Nonnull
    public String getQuestion() {
        return question;
    }

    public void setQuestion(@Nonnull String question) {
        this.question = question;
    }

    @Nonnull
    public List<String> getOptions() {
        return options;
    }

    public void setOptions(@Nonnull List<String> options) {
        this.options = options;
    }

    @Nullable
    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(@Nullable Boolean anonymous) {
        isAnonymous = anonymous;
    }

    @Nullable
    public String getType() {
        return type;
    }

    public void setType(@Nullable String type) {
        this.type = type;
    }

    @Nullable
    public Boolean getAllowsMultipleAnswers() {
        return allowsMultipleAnswers;
    }

    public void setAllowsMultipleAnswers(@Nullable Boolean allowsMultipleAnswers) {
        this.allowsMultipleAnswers = allowsMultipleAnswers;
    }

    @Nullable
    public Integer getCorrectOptionId() {
        return correctOptionId;
    }

    public void setCorrectOptionId(@Nullable Integer correctOptionId) {
        this.correctOptionId = correctOptionId;
    }

    @Nullable
    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(@Nullable Boolean closed) {
        isClosed = closed;
    }
}
