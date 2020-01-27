package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * This object contains information about one member of a chat.
 * @see <a href="https://core.telegram.org/bots/api#chatmember">Chat Member</a>
 */
@Introspected
public class ChatMember {
    /**
     * Information about the user.
     */
    @Nonnull
    @NotNull
    @Valid
    private User user;

    /**
     * The member's status in the chat. Can be “creator”, “administrator”, “member”, “restricted”, “left” or “kicked”.
     */
    private String status;

    /**
     * Owner and administrators only. Custom title for this user
     */
    @Nullable
    @JsonProperty("custom_title")
    private String customTitle;

    /**
     * Restricted and kicked only. Date when restrictions will be lifted for this user; unix time.
     */
    @Nullable
    @JsonProperty("until_date")
    private Integer untilDate;

    /**
     * Administrators only. True, if the bot is allowed to edit administrator privileges of that user.
     */
    @Nullable
    @JsonProperty("can_be_edited")
    private Boolean canBeEdited;

    /**
     * Administrators only. True, if the administrator can post in the channel; channels only.
     */
    @Nullable
    @JsonProperty("can_post_messages")
    private Boolean canPostMessages;

    /**
     * Administrators only. True, if the administrator can edit messages of other users and can pin messages; channels only.
     */
    @Nullable
    @JsonProperty("can_edit_messages")
    private Boolean canEditMessages;

    /**
     * Administrators only. True, if the administrator can delete messages of other users.
     */
    @Nullable
    private Boolean canDeleteMessages;

    /**
     * Administrators only. True, if the administrator can restrict, ban or unban chat members.
     */
    @Nullable
    @JsonProperty("can_restrict_members")
    private Boolean canRestrictMembers;

    /**
     * Administrators only. True, if the administrator can add new administrators with a subset of his own privileges or demote administrators that he has promoted, directly or indirectly (promoted by administrators that were appointed by the user)
     */
    @Nullable
    @JsonProperty("can_promote_members")
    private Boolean canPromoteMembers;

    /**
     * Administrators and restricted only. True, if the user is allowed to change the chat title, photo and other settings.
     */
    @JsonProperty("can_change_info")
    @Nullable
    private Boolean canChangeInfo;

    /**
     * Administrators and restricted only. True, if the user is allowed to invite new users to the chat
     */
    @Nullable
    @JsonProperty("can_invite_users")
    private Boolean canInviteUsers;

    /**
     * Administrators and restricted only. True, if the user is allowed to pin messages; groups and supergroups only.
     */
    @Nullable
    @JsonProperty("can_pin_messages")
    private Boolean canPinMessages;

    /**
     * Restricted only. True, if the user is a member of the chat at the moment of the request.
     */
    @Nullable
    @JsonProperty("is_member")
    private Boolean isMember;

    /**
     * Restricted only. True, if the user is allowed to send text messages, contacts, locations and venues.
     */
    @Nullable
    @JsonProperty("can_send_messages")
    private Boolean canSendMessages;

    /**
     * Restricted only. True, if the user is allowed to send audios, documents, photos, videos, video notes and voice notes.
     */
    @Nullable
    @JsonProperty("can_send_media_messages")
    private Boolean canSendMediaMessages;

    /**
     * Restricted only. True, if the user is allowed to send polls.
     */
    @Nullable
    @JsonProperty("can_send_polls")
    private Boolean canSendPolls;

    /**
     * Restricted only. True, if the user is allowed to send animations, games, stickers and use inline bots.
     */
    @Nullable
    @JsonProperty("can_send_other_messages")
    private Boolean canSendOtherMessages;

    /**
     *  Restricted only. True, if the user is allowed to add web page previews to their messages.
     */
    @Nullable
    @JsonProperty("can_add_web_page_previews")
    private Boolean canAddWebPagePreviews;

    public ChatMember() {
    }

    @Nonnull
    public User getUser() {
        return user;
    }

    public void setUser(@Nonnull User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Nullable
    public String getCustomTitle() {
        return customTitle;
    }

    public void setCustomTitle(@Nullable String customTitle) {
        this.customTitle = customTitle;
    }

    @Nullable
    public Integer getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(@Nullable Integer untilDate) {
        this.untilDate = untilDate;
    }

    @Nullable
    public Boolean getCanBeEdited() {
        return canBeEdited;
    }

    public void setCanBeEdited(@Nullable Boolean canBeEdited) {
        this.canBeEdited = canBeEdited;
    }

    @Nullable
    public Boolean getCanPostMessages() {
        return canPostMessages;
    }

    public void setCanPostMessages(@Nullable Boolean canPostMessages) {
        this.canPostMessages = canPostMessages;
    }

    @Nullable
    public Boolean getCanEditMessages() {
        return canEditMessages;
    }

    public void setCanEditMessages(@Nullable Boolean canEditMessages) {
        this.canEditMessages = canEditMessages;
    }

    @Nullable
    public Boolean getCanDeleteMessages() {
        return canDeleteMessages;
    }

    public void setCanDeleteMessages(@Nullable Boolean canDeleteMessages) {
        this.canDeleteMessages = canDeleteMessages;
    }

    @Nullable
    public Boolean getCanRestrictMembers() {
        return canRestrictMembers;
    }

    public void setCanRestrictMembers(@Nullable Boolean canRestrictMembers) {
        this.canRestrictMembers = canRestrictMembers;
    }

    @Nullable
    public Boolean getCanPromoteMembers() {
        return canPromoteMembers;
    }

    public void setCanPromoteMembers(@Nullable Boolean canPromoteMembers) {
        this.canPromoteMembers = canPromoteMembers;
    }

    @Nullable
    public Boolean getCanChangeInfo() {
        return canChangeInfo;
    }

    public void setCanChangeInfo(@Nullable Boolean canChangeInfo) {
        this.canChangeInfo = canChangeInfo;
    }

    @Nullable
    public Boolean getCanInviteUsers() {
        return canInviteUsers;
    }

    public void setCanInviteUsers(@Nullable Boolean canInviteUsers) {
        this.canInviteUsers = canInviteUsers;
    }

    @Nullable
    public Boolean getCanPinMessages() {
        return canPinMessages;
    }

    public void setCanPinMessages(@Nullable Boolean canPinMessages) {
        this.canPinMessages = canPinMessages;
    }

    @Nullable
    public Boolean getMember() {
        return isMember;
    }

    public void setMember(@Nullable Boolean member) {
        isMember = member;
    }

    @Nullable
    public Boolean getCanSendMessages() {
        return canSendMessages;
    }

    public void setCanSendMessages(@Nullable Boolean canSendMessages) {
        this.canSendMessages = canSendMessages;
    }

    @Nullable
    public Boolean getCanSendMediaMessages() {
        return canSendMediaMessages;
    }

    public void setCanSendMediaMessages(@Nullable Boolean canSendMediaMessages) {
        this.canSendMediaMessages = canSendMediaMessages;
    }

    @Nullable
    public Boolean getCanSendPolls() {
        return canSendPolls;
    }

    public void setCanSendPolls(@Nullable Boolean canSendPolls) {
        this.canSendPolls = canSendPolls;
    }

    @Nullable
    public Boolean getCanSendOtherMessages() {
        return canSendOtherMessages;
    }

    public void setCanSendOtherMessages(@Nullable Boolean canSendOtherMessages) {
        this.canSendOtherMessages = canSendOtherMessages;
    }

    @Nullable
    public Boolean getCanAddWebPagePreviews() {
        return canAddWebPagePreviews;
    }

    public void setCanAddWebPagePreviews(@Nullable Boolean canAddWebPagePreviews) {
        this.canAddWebPagePreviews = canAddWebPagePreviews;
    }

    @Override
    public String toString() {
        return "ChatMember{" +
                "user=" + (user != null ? user.toString() : "") +
                ", status='" + status + '\'' +
                ", customTitle='" + customTitle + '\'' +
                ", untilDate=" + untilDate +
                ", canBeEdited=" + canBeEdited +
                ", canPostMessages=" + canPostMessages +
                ", canEditMessages=" + canEditMessages +
                ", canDeleteMessages=" + canDeleteMessages +
                ", canRestrictMembers=" + canRestrictMembers +
                ", canPromoteMembers=" + canPromoteMembers +
                ", canChangeInfo=" + canChangeInfo +
                ", canInviteUsers=" + canInviteUsers +
                ", canPinMessages=" + canPinMessages +
                ", isMember=" + isMember +
                ", canSendMessages=" + canSendMessages +
                ", canSendMediaMessages=" + canSendMediaMessages +
                ", canSendPolls=" + canSendPolls +
                ", canSendOtherMessages=" + canSendOtherMessages +
                ", canAddWebPagePreviews=" + canAddWebPagePreviews +
                '}';
    }
}
