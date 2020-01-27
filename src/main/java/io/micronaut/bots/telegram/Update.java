package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@Introspected
public class Update {

    /**
     * The update‘s unique identifier. Update identifiers start from a certain positive number and increase sequentially. This ID becomes especially handy if you’re using Webhooks, since it allows you to ignore repeated updates or to restore the correct update sequence, should they get out of order. If there are no new updates for at least a week, then identifier of the next update will be chosen randomly instead of sequentially.
     */
    @JsonProperty("update_id")
    @Nonnull
    @NotNull
    private Integer updateId;

    /**
     * New incoming message of any kind — text, photo, sticker, etc.
     */
    @Nullable
    private Message message;

    /**
     * New version of a message that is known to the bot and was edited
     */
    @Nullable
    @JsonProperty("edited_message")
    private Message editedMessage;

    /**
     * New incoming channel post of any kind — text, photo, sticker, etc.
     */
    @Nullable
    @JsonProperty("channel_post")
    private Message channelPost;

    /**
     * New version of a channel post that is known to the bot and was edited
     */
    @Nullable
    @JsonProperty("edited_channel_post")
    private Message editedChannelPost;

    /**
     * New incoming inline query
     */
    @Nullable
    @JsonProperty("inline_query")
    private InlineQuery inlineQuery;

    /**
     * The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
     */
    @Nullable
    @JsonProperty("chosen_inline_result")
    private ChosenInlineResult chosenInlineResult;

    /**
     * New incoming callback query
     */
    @Nullable
    @JsonProperty("callback_query")
    private CallbackQuery callbackQuery;

    /**
     *  New incoming shipping query. Only for invoices with flexible price
     */
    @Nullable
    @JsonProperty("shipping_query")
    private ShippingQuery shippingQuery;

    /**
     *  New incoming pre-checkout query. Contains full information about checkout
     */
    @Nullable
    @JsonProperty("pre_checkout_query")
    private PreCheckoutQuery preCheckoutQuery;

    /**
     * New poll state. Bots receive only updates about stopped polls and polls, which are sent by the bot.
     */
    @Nullable
    private Poll poll;

    public Update() {
    }

    @Nonnull
    public Integer getUpdateId() {
        return updateId;
    }

    public void setUpdateId(@Nonnull Integer updateId) {
        this.updateId = updateId;
    }

    @Nullable
    public Message getMessage() {
        return message;
    }

    public void setMessage(@Nullable Message message) {
        this.message = message;
    }

    @Nullable
    public Message getEditedMessage() {
        return editedMessage;
    }

    public void setEditedMessage(@Nullable Message editedMessage) {
        this.editedMessage = editedMessage;
    }

    @Nullable
    public Message getChannelPost() {
        return channelPost;
    }

    public void setChannelPost(@Nullable Message channelPost) {
        this.channelPost = channelPost;
    }

    @Nullable
    public Message getEditedChannelPost() {
        return editedChannelPost;
    }

    public void setEditedChannelPost(@Nullable Message editedChannelPost) {
        this.editedChannelPost = editedChannelPost;
    }

    @Nullable
    public InlineQuery getInlineQuery() {
        return inlineQuery;
    }

    public void setInlineQuery(@Nullable InlineQuery inlineQuery) {
        this.inlineQuery = inlineQuery;
    }

    @Nullable
    public ChosenInlineResult getChosenInlineResult() {
        return chosenInlineResult;
    }

    public void setChosenInlineResult(@Nullable ChosenInlineResult chosenInlineResult) {
        this.chosenInlineResult = chosenInlineResult;
    }

    @Nullable
    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }

    public void setCallbackQuery(@Nullable CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    @Nullable
    public ShippingQuery getShippingQuery() {
        return shippingQuery;
    }

    public void setShippingQuery(@Nullable ShippingQuery shippingQuery) {
        this.shippingQuery = shippingQuery;
    }

    @Nullable
    public PreCheckoutQuery getPreCheckoutQuery() {
        return preCheckoutQuery;
    }

    public void setPreCheckoutQuery(@Nullable PreCheckoutQuery preCheckoutQuery) {
        this.preCheckoutQuery = preCheckoutQuery;
    }

    @Nullable
    public Poll getPoll() {
        return poll;
    }

    public void setPoll(@Nullable Poll poll) {
        this.poll = poll;
    }


    @Override
    public String toString() {
        return "Update{" +
                "updateId=" + updateId +
                ", message=" + (message != null ? message.toString() : "") +
                ", editedMessage=" + (editedMessage != null ? editedMessage.toString() : "") +
                ", channelPost=" + (channelPost != null ? channelPost.toString() : "") +
                ", editedChannelPost=" + (editedChannelPost  != null ? editedChannelPost.toString() : "") +
                ", inlineQuery=" + (inlineQuery != null ? inlineQuery.toString() : "") +
                ", chosenInlineResult=" + (chosenInlineResult != null ? chosenInlineResult.toString() : "") +
                ", callbackQuery=" + (callbackQuery != null ? callbackQuery.toString() : "") +
                ", shippingQuery=" + (shippingQuery != null ? shippingQuery.toString() : "") +
                ", preCheckoutQuery=" + (preCheckoutQuery != null ? preCheckoutQuery.toString() : "") +
                ", poll=" + (poll != null ? poll.toString() : "") +
                '}';
    }
}
