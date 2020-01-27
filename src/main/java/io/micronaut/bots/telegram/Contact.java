package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

/**
 * This object represents a phone contact.
 * @see <a href="https://core.telegram.org/bots/api#contact">This object represents a phone contact.</a>
 */
@Introspected
public class Contact {

    /**
     * Contact's phone number.
     */
    @JsonProperty("phone_number")
    @Nonnull
    @NotBlank
    private String phoneNumber;

    /**
     * Contact's first name
     */
    @Nonnull
    @NotBlank
    @JsonProperty("first_name")
    private String firstName;
    /**
     * Contact's last name.
     */
    @Nullable
    @JsonProperty("last_name")
    private String lastName;

    /**
     * Contact's user identifier in Telegram
     */
    @Nullable
    @JsonProperty("user_id")
    private Integer userId;

    /**
     * Additional data about the contact in the form of a vCard
     */
    @Nullable
    private String vcard;

    public Contact() {
    }

    @Nonnull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nonnull String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@Nullable Integer userId) {
        this.userId = userId;
    }

    @Nullable
    public String getVcard() {
        return vcard;
    }

    public void setVcard(@Nullable String vcard) {
        this.vcard = vcard;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userId=" + userId +
                ", vcard='" + vcard + '\'' +
                '}';
    }
}
