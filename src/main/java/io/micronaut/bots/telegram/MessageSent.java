package io.micronaut.bots.telegram;

import io.micronaut.bots.telegram.Message;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@Introspected
public class MessageSent {
    @Nonnull
    @NotNull
    private Boolean ok;

    @Nullable
    private Message result;

    public MessageSent() {
    }

    @Nonnull
    public Boolean getOk() {
        return ok;
    }

    public void setOk(@Nonnull Boolean ok) {
        this.ok = ok;
    }

    @Nullable
    public Message getResult() {
        return result;
    }

    public void setResult(@Nullable Message result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MessageSent{" +
                "ok=" + ok +
                ", result=" + (result != null ? result.toString() : "") +
                '}';
    }
}
