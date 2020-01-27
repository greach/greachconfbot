package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

/**
 * Upon receiving a message with this object, Telegram clients will display a reply interface to the user (act as if the user has selected the bot‘s message and tapped ’Reply'). This can be extremely useful if you want to create user-friendly step-by-step interfaces without having to sacrifice privacy mode.
 * @see <a href="https://core.telegram.org/bots/api#forcereply">Force Reply</a>
 */
@Introspected
public class ForceReply {

    /**
     * Shows reply interface to the user, as if they manually selected the bot‘s message and tapped ’Reply'
     */
    @Nonnull
    @NotNull
    @JsonProperty("force_reply")
    private Boolean forceReply = Boolean.TRUE;

    /**
     * Use this parameter if you want to force reply from specific users only. Targets: 1) users that are @mentioned in the text of the Message object; 2) if the bot's message is a reply (has reply_to_message_id), sender of the original message.
     */
    @Nullable
    private Boolean selective;

    public ForceReply() {
    }

    @Nonnull
    public Boolean getForceReply() {
        return forceReply;
    }

    public void setForceReply(@Nonnull Boolean forceReply) {
        this.forceReply = forceReply;
    }

    @Nullable
    public Boolean getSelective() {
        return selective;
    }

    public void setSelective(@Nullable Boolean selective) {
        this.selective = selective;
    }

    @Override
    public String toString() {
        return "ForceReply{" +
                "forceReply=" + forceReply +
                ", selective=" + selective +
                '}';
    }
}
