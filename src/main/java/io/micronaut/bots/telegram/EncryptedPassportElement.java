package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Introspected
public class EncryptedPassportElement {

    /**
     * Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
     */
    @Nonnull
    @NotBlank
    private String type;

    /**
     * Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private String data;

    /**
     * User's verified phone number, available only for “phone_number” type
      */
    @Nullable
    @JsonProperty("phone_number")
    private String phoneNumber;

    /**
     * User's verified email address, available only for “email” type
     */
    @Nullable
    private String email;

    /**
     * Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private List<PassportFile> files;

    /**
     * Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
      */
    @Nullable
    @JsonProperty("front_side")
    private PassportFile frontSide;

    /**
     * Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    @JsonProperty("reverse_side")
    private PassportFile reverseSide;

    /**
     * 	Optional. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    private PassportFile selfie;

    /**
     * Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying EncryptedCredentials.
     */
    @Nullable
    List<PassportFile> translation;

    /**
     * String	Base64-encoded element hash for using in PassportElementErrorUnspecified
     */
    @NotBlank
    @Nonnull
    private String hash;

    public EncryptedPassportElement() {
    }

    @Nonnull
    public String getType() {
        return type;
    }

    public void setType(@Nonnull String type) {
        this.type = type;
    }

    @Nullable
    public String getData() {
        return data;
    }

    public void setData(@Nullable String data) {
        this.data = data;
    }

    @Nullable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@Nullable String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public List<PassportFile> getFiles() {
        return files;
    }

    public void setFiles(@Nullable List<PassportFile> files) {
        this.files = files;
    }

    @Nullable
    public PassportFile getFrontSide() {
        return frontSide;
    }

    public void setFrontSide(@Nullable PassportFile frontSide) {
        this.frontSide = frontSide;
    }

    @Nullable
    public PassportFile getReverseSide() {
        return reverseSide;
    }

    public void setReverseSide(@Nullable PassportFile reverseSide) {
        this.reverseSide = reverseSide;
    }

    @Nullable
    public PassportFile getSelfie() {
        return selfie;
    }

    public void setSelfie(@Nullable PassportFile selfie) {
        this.selfie = selfie;
    }

    @Nullable
    public List<PassportFile> getTranslation() {
        return translation;
    }

    public void setTranslation(@Nullable List<PassportFile> translation) {
        this.translation = translation;
    }

    @Nonnull
    public String getHash() {
        return hash;
    }

    public void setHash(@Nonnull String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "EncryptedPassportElement{" +
                "type='" + type + '\'' +
                ", data='" + data + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", files=" + files +
                ", files=" + (files != null ?  String.join(",",files.stream().map(PassportFile::toString).collect(Collectors.toList())) : "") +
                ", frontSide=" + (frontSide != null ? frontSide.toString() : "") +
                ", reverseSide=" + (reverseSide != null ? reverseSide.toString() : "") +
                ", selfie=" + (selfie != null ? selfie.toString() : "") +
                ", translation=" + (translation != null ?  String.join(",",translation.stream().map(PassportFile::toString).collect(Collectors.toList())) : "") +

                ", hash='" + hash + '\'' +
                '}';
    }
}
