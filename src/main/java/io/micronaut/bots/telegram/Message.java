package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a message.
 * @see <a href="https://core.telegram.org/bots/api#message">Message</a>
 */
@Introspected
public class Message {

    /**
     * Unique message identifier inside this chat
     */
    @JsonProperty("message_id")
    @Nonnull
    @NotNull
    private Integer messageId;

    /**
     * Sender, empty for messages sent to channels
     */
    @Nullable
    @Valid
    @NotNull
    private User from;

    /**
     * Date the message was sent in Unix time
     */
    @Nonnull
    @NotNull
    private Integer date;

    /**
     * Conversation the message belongs to
     */
    @Nonnull
    @Valid
    @NotNull
    private Chat chat;

    /**
     * For forwarded messages, sender of the original message
     */
    @Nullable
    @Valid
    @JsonProperty("forward_from")
    private User forwardFrom;

    /**
     * For messages forwarded from channels, information about the original channel.
     */
    @Nullable
    @Valid
    @JsonProperty("forward_from_chat")
    private Chat forwardFromChat;

    /**
     * For messages forwarded from channels, identifier of the original message in the channel.
     */
    @Nullable
    @JsonProperty("forward_from_message_id")
    private Integer forwardFromMessageId;

    /**
     * For messages forwarded from channels, signature of the post author if present.
     */
    @Nullable
    @JsonProperty("forward_signature")
    private String forwardSignature;

    /**
     * Sender's name for messages forwarded from users who disallow adding a link to their account in forwarded messages
     */
    @Nullable
    @JsonProperty("forward_sender_name")
    private String forwardSenderName;

    /**
     * For forwarded messages, date the original message was sent in Unix time.
     */
    @Nullable
    @JsonProperty("forward_date")
    private Integer forwardDate;

    /**
     * For replies, the original message. Note that the Message object in this field will not contain further reply_to_message fields even if it itself is a reply.
     */
    @Nullable
    @JsonProperty("reply_to_message")
    private Message replyToMessage;

    /**
     * Date the message was last edited in Unix time.
     */
    @Nullable
    @JsonProperty("edit_date")
    private Integer editDate;

    /**
     * The unique identifier of a media message group this message belongs to.
     */
    @Nullable
    @JsonProperty("media_group_id")
    private String mediaGroupId;

    /**
     * Signature of the post author for messages in channels.
     */
    @Nullable
    private String authorSignature;

    /**
     * For text messages, the actual UTF-8 text of the message, 0-4096 characters.
     */
    @Nullable
    private String text;


    /**
     * For text messages, special entities like usernames, URLs, bot commands, etc. that appear in the text
     */
    @Nullable
    private List<MessageEntity> entities;

    /**
     * For messages with a caption, special entities like usernames, URLs, bot commands, etc. that appear in the caption.
     */
    @Nullable
    @JsonProperty("caption_entities")
    private List<MessageEntity> captionEntities;

    /**
     * Message is an audio file, information about the file.
     */
    @Nullable
    private Audio audio;

    /**
     * Message is a general file, information about the file.
     */
    @Nullable
    private Document document;

    /**
     * Message is an animation, information about the animation. For backward compatibility, when this field is set, the document field will also be set.
     */
    @Nullable
    private Animation animation;

    /**
     * Message is a game, information about the game.
     */
    @Nullable
    private Game game;

    /**
     * Message is a photo, available sizes of the photo.
     */
    @Nullable
    private List<PhotoSize> photo;

    /**
     * Message is a sticker, information about the sticker
     */
    @Nullable
    private Sticker sticker;

    /**
     * Message is a video, information about the video.
     */
    @Nullable
    private Video video;

    /**
     * Message is a voice message, information about the file
     */
    @Nullable
    private Voice voice;

    /**
     * Message is a video note, information about the video message.
     */
    @Nullable
    @JsonProperty("video_note")
    private VideoNote videoNote;

    /**
     * Caption for the animation, audio, document, photo, video or voice, 0-1024 characters
     */
    @Nullable
    private String caption;

    /**
     * Message is a shared contact, information about the contact.
     */
    @Nullable
    private Contact contact;

    /**
     * Message is a shared location, information about the location.
     */
    @Nullable
    private Location location;

    /**
     * Message is a venue, information about the venue.
     */
    @Nullable
    private Venue venue;

    /**
     *  Message is a native poll, information about the poll.
     */
    @Nullable
    private Poll poll;

    /**
     * New members that were added to the group or supergroup and information about them (the bot itself may be one of these members).
     */
    @Nullable
    @JsonProperty("new_chat_members")
    private List<User> newChatMembers;


    /**
     * A member was removed from the group, information about them (this member may be the bot itself)
     */
    @Nullable
    @JsonProperty("left_chat_member")
    private User leftChatMember;

    /**
     * A chat title was changed to this value.
     */
    @JsonProperty("new_chat_title")
    @Nullable
    private String newChatTitle;


    /**
     *  A chat photo was change to this value.
     */
    @Nullable
    @JsonProperty("new_chat_photo")
    private List<PhotoSize> newChatPhoto;

    /**
     * Service message: the chat photo was deleted.
     */
    @Nullable
    @JsonProperty("delete_chat_photo")
    private Boolean deleteChatPhoto;

    /**
     * Service message: the group has been created
     */
    @Nullable
    @JsonProperty("group_chat_created")
    private Boolean groupChatCreated;

    /**
     * Service message: the supergroup has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a supergroup when it is created. It can only be found in reply_to_message if someone replies to a very first message in a directly created supergroup.
     */
    @Nullable
    @JsonProperty("supergroup_chat_created")
    private Boolean supergroupChatCreated;

    /**
     * Service message: the channel has been created. This field can‘t be received in a message coming through updates, because bot can’t be a member of a channel when it is created. It can only be found in reply_to_message if someone replies to a very first message in a channel.
     */
    @Nullable
    @JsonProperty("channel_chat_created")
    private Boolean channelChatCreated;

    /**
     * The group has been migrated to a supergroup with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier.
     */
    @JsonProperty("migrate_to_chat_id")
    @Nullable
    private Integer migrateToChatId;


    /**
     * The supergroup has been migrated from a group with the specified identifier. This number may be greater than 32 bits and some programming languages may have difficulty/silent defects in interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or double-precision float type are safe for storing this identifier
     */
    @Nullable
    @JsonProperty("migrate_from_chat_id")
    private Integer migrateFromChatId;

    /**
     * Specified message was pinned. Note that the Message object in this field will not contain further reply_to_message fields even if it is itself a reply.
     */
    @Nullable
    private Message pinnedMessage;

    /**
     *  Message is an invoice for a payment, information about the invoice.
     */
    @Nullable
    private Invoice invoice;

    /**
     * Message is a service message about a successful payment, information about the payment.
     */
    @Nullable
    @JsonProperty("successful_payment")
    private SuccessfulPayment successfulPayment;

    /**
     * The domain name of the website on which the user has logged in.
     */
    @Nullable
    @JsonProperty("connected_website")
    private String connectedWebsite;

    /**
     * Telegram Passport data.
     */
    @Nullable
    private PassportData passportData;

    /**
     * Inline keyboard attached to the message. login_url buttons are represented as ordinary url buttons.
     */
    @Nullable
    @JsonProperty("reply_markup")
    InlineKeyboardMarkup replyMarkup;

    public Message() {

    }

    @Nonnull
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(@Nonnull Integer messageId) {
        this.messageId = messageId;
    }

    @Nullable
    public User getFrom() {
        return from;
    }

    public void setFrom(@Nullable User from) {
        this.from = from;
    }

    @Nonnull
    public Integer getDate() {
        return date;
    }

    public void setDate(@Nonnull Integer date) {
        this.date = date;
    }

    @Nonnull
    public Chat getChat() {
        return chat;
    }

    public void setChat(@Nonnull Chat chat) {
        this.chat = chat;
    }

    @Nullable
    public User getForwardFrom() {
        return forwardFrom;
    }

    public void setForwardFrom(@Nullable User forwardFrom) {
        this.forwardFrom = forwardFrom;
    }

    @Nullable
    public Chat getForwardFromChat() {
        return forwardFromChat;
    }

    public void setForwardFromChat(@Nullable Chat forwardFromChat) {
        this.forwardFromChat = forwardFromChat;
    }

    @Nullable
    public Integer getForwardFromMessageId() {
        return forwardFromMessageId;
    }

    public void setForwardFromMessageId(@Nullable Integer forwardFromMessageId) {
        this.forwardFromMessageId = forwardFromMessageId;
    }

    @Nullable
    public String getForwardSignature() {
        return forwardSignature;
    }

    public void setForwardSignature(@Nullable String forwardSignature) {
        this.forwardSignature = forwardSignature;
    }

    @Nullable
    public String getForwardSenderName() {
        return forwardSenderName;
    }

    public void setForwardSenderName(@Nullable String forwardSenderName) {
        this.forwardSenderName = forwardSenderName;
    }

    @Nullable
    public Integer getForwardDate() {
        return forwardDate;
    }

    public void setForwardDate(@Nullable Integer forwardDate) {
        this.forwardDate = forwardDate;
    }

    @Nullable
    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public void setReplyToMessage(@Nullable Message replyToMessage) {
        this.replyToMessage = replyToMessage;
    }

    @Nullable
    public Integer getEditDate() {
        return editDate;
    }

    public void setEditDate(@Nullable Integer editDate) {
        this.editDate = editDate;
    }

    @Nullable
    public String getMediaGroupId() {
        return mediaGroupId;
    }

    public void setMediaGroupId(@Nullable String mediaGroupId) {
        this.mediaGroupId = mediaGroupId;
    }

    @Nullable
    public String getAuthorSignature() {
        return authorSignature;
    }

    public void setAuthorSignature(@Nullable String authorSignature) {
        this.authorSignature = authorSignature;
    }

    @Nullable
    public String getText() {
        return text;
    }

    public void setText(@Nullable String text) {
        this.text = text;
    }

    @Nullable
    public List<MessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(@Nullable List<MessageEntity> entities) {
        this.entities = entities;
    }

    @Nullable
    public List<MessageEntity> getCaptionEntities() {
        return captionEntities;
    }

    public void setCaptionEntities(@Nullable List<MessageEntity> captionEntities) {
        this.captionEntities = captionEntities;
    }

    @Nullable
    public Audio getAudio() {
        return audio;
    }

    public void setAudio(@Nullable Audio audio) {
        this.audio = audio;
    }

    @Nullable
    public Document getDocument() {
        return document;
    }

    public void setDocument(@Nullable Document document) {
        this.document = document;
    }

    @Nullable
    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(@Nullable Animation animation) {
        this.animation = animation;
    }

    @Nullable
    public Game getGame() {
        return game;
    }

    public void setGame(@Nullable Game game) {
        this.game = game;
    }

    @Nullable
    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public void setPhoto(@Nullable List<PhotoSize> photo) {
        this.photo = photo;
    }

    @Nullable
    public Sticker getSticker() {
        return sticker;
    }

    public void setSticker(@Nullable Sticker sticker) {
        this.sticker = sticker;
    }

    @Nullable
    public Video getVideo() {
        return video;
    }

    public void setVideo(@Nullable Video video) {
        this.video = video;
    }

    @Nullable
    public Voice getVoice() {
        return voice;
    }

    public void setVoice(@Nullable Voice voice) {
        this.voice = voice;
    }

    @Nullable
    public VideoNote getVideoNote() {
        return videoNote;
    }

    public void setVideoNote(@Nullable VideoNote videoNote) {
        this.videoNote = videoNote;
    }

    @Nullable
    public String getCaption() {
        return caption;
    }

    public void setCaption(@Nullable String caption) {
        this.caption = caption;
    }

    @Nullable
    public Contact getContact() {
        return contact;
    }

    public void setContact(@Nullable Contact contact) {
        this.contact = contact;
    }

    @Nullable
    public Location getLocation() {
        return location;
    }

    public void setLocation(@Nullable Location location) {
        this.location = location;
    }

    @Nullable
    public Venue getVenue() {
        return venue;
    }

    public void setVenue(@Nullable Venue venue) {
        this.venue = venue;
    }

    @Nullable
    public Poll getPoll() {
        return poll;
    }

    public void setPoll(@Nullable Poll poll) {
        this.poll = poll;
    }

    @Nullable
    public List<User> getNewChatMembers() {
        return newChatMembers;
    }

    public void setNewChatMembers(@Nullable List<User> newChatMembers) {
        this.newChatMembers = newChatMembers;
    }

    @Nullable
    public User getLeftChatMember() {
        return leftChatMember;
    }

    public void setLeftChatMember(@Nullable User leftChatMember) {
        this.leftChatMember = leftChatMember;
    }

    @Nullable
    public String getNewChatTitle() {
        return newChatTitle;
    }

    public void setNewChatTitle(@Nullable String newChatTitle) {
        this.newChatTitle = newChatTitle;
    }

    @Nullable
    public List<PhotoSize> getNewChatPhoto() {
        return newChatPhoto;
    }

    public void setNewChatPhoto(@Nullable List<PhotoSize> newChatPhoto) {
        this.newChatPhoto = newChatPhoto;
    }

    @Nullable
    public Boolean getDeleteChatPhoto() {
        return deleteChatPhoto;
    }

    public void setDeleteChatPhoto(@Nullable Boolean deleteChatPhoto) {
        this.deleteChatPhoto = deleteChatPhoto;
    }

    @Nullable
    public Boolean getGroupChatCreated() {
        return groupChatCreated;
    }

    public void setGroupChatCreated(@Nullable Boolean groupChatCreated) {
        this.groupChatCreated = groupChatCreated;
    }

    @Nullable
    public Boolean getSupergroupChatCreated() {
        return supergroupChatCreated;
    }

    public void setSupergroupChatCreated(@Nullable Boolean supergroupChatCreated) {
        this.supergroupChatCreated = supergroupChatCreated;
    }

    @Nullable
    public Boolean getChannelChatCreated() {
        return channelChatCreated;
    }

    public void setChannelChatCreated(@Nullable Boolean channelChatCreated) {
        this.channelChatCreated = channelChatCreated;
    }

    @Nullable
    public Integer getMigrateToChatId() {
        return migrateToChatId;
    }

    public void setMigrateToChatId(@Nullable Integer migrateToChatId) {
        this.migrateToChatId = migrateToChatId;
    }

    @Nullable
    public Integer getMigrateFromChatId() {
        return migrateFromChatId;
    }

    public void setMigrateFromChatId(@Nullable Integer migrateFromChatId) {
        this.migrateFromChatId = migrateFromChatId;
    }

    @Nullable
    public Message getPinnedMessage() {
        return pinnedMessage;
    }

    public void setPinnedMessage(@Nullable Message pinnedMessage) {
        this.pinnedMessage = pinnedMessage;
    }

    @Nullable
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(@Nullable Invoice invoice) {
        this.invoice = invoice;
    }

    @Nullable
    public SuccessfulPayment getSuccessfulPayment() {
        return successfulPayment;
    }

    public void setSuccessfulPayment(@Nullable SuccessfulPayment successfulPayment) {
        this.successfulPayment = successfulPayment;
    }

    @Nullable
    public String getConnectedWebsite() {
        return connectedWebsite;
    }

    public void setConnectedWebsite(@Nullable String connectedWebsite) {
        this.connectedWebsite = connectedWebsite;
    }

    @Nullable
    public PassportData getPassportData() {
        return passportData;
    }

    public void setPassportData(@Nullable PassportData passportData) {
        this.passportData = passportData;
    }

    @Nullable
    public InlineKeyboardMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(@Nullable InlineKeyboardMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", from=" + (from != null ? from.toString() : "") +
                ", date=" + date +
                ", chat=" + (chat != null ? chat.toString() : "") +
                ", forwardFrom=" + (forwardFrom != null ? forwardFrom.toString() : "") +
                ", forwardFromChat=" + (forwardFromChat != null ? forwardFromChat.toString() : "") +
                ", forwardFromMessageId=" + forwardFromMessageId +
                ", forwardSignature='" + forwardSignature + '\'' +
                ", forwardSenderName='" + forwardSenderName + '\'' +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + (replyToMessage != null ? replyToMessage.toString() : "") +
                ", editDate=" + editDate +
                ", mediaGroupId='" + mediaGroupId + '\'' +
                ", authorSignature='" + authorSignature + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + (entities != null ?  String.join(",",entities.stream().map(MessageEntity::toString).collect(Collectors.toList())) : "") +
                ", captionEntities=" + (captionEntities != null ?  String.join(",",captionEntities.stream().map(MessageEntity::toString).collect(Collectors.toList())) : "") +
                ", audio=" + (audio != null ? audio.toString() : "") +
                ", document=" + (document != null ? document.toString() : "") +
                ", animation=" + (animation != null ? animation.toString() : "") +
                ", game=" + (game != null ? game.toString() : "") +
                ", photo=" + (photo != null ?  String.join(",",photo.stream().map(PhotoSize::toString).collect(Collectors.toList())) : "") +
                ", sticker=" + (sticker != null ? sticker.toString() : "") +
                ", video=" + (video != null ? video.toString() : "") +
                ", voice=" + (voice != null ? voice.toString() : "") +
                ", videoNote=" + (videoNote != null ? videoNote.toString() : "") +
                ", caption='" + caption + '\'' +
                ", contact=" + (contact != null ? contact.toString() : "") +
                ", location=" + (location != null ? location.toString() : "") +
                ", venue=" + (venue != null ? venue.toString() : "") +
                ", poll=" + (poll  != null ? poll.toString() : "") +
                ", newChatMembers=" + (newChatMembers != null ?  String.join(",",newChatMembers.stream().map(User::toString).collect(Collectors.toList())) : "") +
                ", leftChatMember=" + (leftChatMember != null ? leftChatMember.toString() : "") +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + (newChatPhoto != null ?  String.join(",",newChatPhoto.stream().map(PhotoSize::toString).collect(Collectors.toList())) : "") +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                ", supergroupChatCreated=" + supergroupChatCreated +
                ", channelChatCreated=" + channelChatCreated +
                ", migrateToChatId=" + migrateToChatId +
                ", migrateFromChatId=" + migrateFromChatId +
                ", pinnedMessage=" + (pinnedMessage != null ? pinnedMessage.toString() : "")  +
                ", invoice=" + (invoice != null ? invoice.toString() : "")  +
                ", successfulPayment=" + (successfulPayment != null ? successfulPayment.toString() : "")  +
                ", connectedWebsite='" + connectedWebsite + '\'' +
                ", passportData=" + (passportData != null ? passportData.toString() : "") +
                ", replyMarkup=" + (replyMarkup  != null ? replyMarkup.toString() : "") +
                '}';
    }
}
