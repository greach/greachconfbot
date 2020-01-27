package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

@Introspected
public class SendContact extends Send  {

    /**
     * Contact's phone number.
     */
    @JsonProperty("phone_number")
    @NotBlank
    @Nonnull
    private String phoneNumber;

    /**
     * Contact's first name.
     */
    @JsonProperty("first_name")
    @NotBlank
    @Nonnull
    private String firstName;

    /**
     * Contact's last name.
     */
    @JsonProperty("last_name")
    @Nullable
    private String lastName;

    /**
     * Additional data about the contact in the form of a vCard, 0-2048 bytes
     */
    @Nullable
    private String vcard;

    public SendContact() {
        super("sendContact");
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
    public String getVcard() {
        return vcard;
    }

    public void setVcard(@Nullable String vcard) {
        this.vcard = vcard;
    }
}
