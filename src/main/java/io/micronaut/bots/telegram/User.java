package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a Telegram user or bot.
 * <a href="https://core.telegram.org/bots/api#user">User</a>
 */
@Introspected
public class User {
    /**
     * Unique identifier for this user or bot
     */
    @Nonnull
    @NotNull
    private Integer id;

    /**
     * True, if this user is a bot
     */
    @JsonProperty("is_bot")
    @Nonnull
    @NotNull
    private Boolean bot;

    /**
     * User‘s or bot’s first name
     */
    @JsonProperty("first_name")
    @Nonnull
    @NotBlank
    private String firstName;

    /**
     * User‘s or bot’s last name
     */
    @JsonProperty("last_name")
    @Nullable
    private String lastName;

    /**
     * User‘s or bot’s username
     */
    @Nullable
    private String username;

    /**
     * IETF language tag of the user's language
     * <a href="https://en.wikipedia.org/wiki/IETF_language_tag">IETF language tag</a>
     */
    @Nullable
    @JsonProperty("language_code")
    String languageCode;

    /**
     * True, if the bot can be invited to groups. Returned only in getMe.
     */
    @Nullable
    @JsonProperty("can_join_groups")
    private Boolean canJoinGroups;

    /**
     * True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    @Nullable
    @JsonProperty("can_read_all_group_messages")
    private Boolean canReadAllGroupMessages;

    /*
     * True, if the bot supports inline queries. Returned only in getMe.
     */
    @Nullable
    @JsonProperty("supports_inline_queries")
    private Boolean supportsInlineQueries;

    public User() {

    }

    @Nonnull
    public Integer getId() {
        return id;
    }

    public void setId(@Nonnull Integer id) {
        this.id = id;
    }

    @Nonnull
    public Boolean getBot() {
        return bot;
    }

    public void setBot(@Nonnull Boolean bot) {
        this.bot = bot;
    }

    @Nonnull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@Nonnull String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public String getUsername() {
        return username;
    }

    public void setUsername(@Nullable String username) {
        this.username = username;
    }

    @Nullable
    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(@Nullable String languageCode) {
        this.languageCode = languageCode;
    }

    @Nullable
    public Boolean getCanJoinGroups() {
        return canJoinGroups;
    }

    public void setCanJoinGroups(@Nullable Boolean canJoinGroups) {
        this.canJoinGroups = canJoinGroups;
    }

    @Nullable
    public Boolean getCanReadAllGroupMessages() {
        return canReadAllGroupMessages;
    }

    public void setCanReadAllGroupMessages(@Nullable Boolean canReadAllGroupMessages) {
        this.canReadAllGroupMessages = canReadAllGroupMessages;
    }

    @Nullable
    public Boolean getSupportsInlineQueries() {
        return supportsInlineQueries;
    }

    public void setSupportsInlineQueries(@Nullable Boolean supportsInlineQueries) {
        this.supportsInlineQueries = supportsInlineQueries;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", bot=" + bot +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", languageCode='" + languageCode + '\'' +
                ", canJoinGroups=" + canJoinGroups +
                ", canReadAllGroupMessages=" + canReadAllGroupMessages +
                ", supportsInlineQueries=" + supportsInlineQueries +
                '}';
    }
}
