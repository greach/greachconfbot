package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Introspected
public class CallbackQueryResponse {

    @NotNull
    @Valid
    @Nonnull
    private AnswerCallbackQuery answerCallbackQuery;

    @Nullable
    private List<@Valid Send> messages;

    public CallbackQueryResponse() {
    }

    @Nonnull
    public AnswerCallbackQuery getAnswerCallbackQuery() {
        return answerCallbackQuery;
    }

    public void setAnswerCallbackQuery(@Nonnull AnswerCallbackQuery answerCallbackQuery) {
        this.answerCallbackQuery = answerCallbackQuery;
    }

    @Nullable
    public List<Send> getMessages() {
        return messages;
    }

    public void setMessages(@Nullable List<Send> messages) {
        this.messages = messages;
    }
}
