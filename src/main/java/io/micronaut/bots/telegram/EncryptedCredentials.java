package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;

/**
 * Contains data required for decrypting and authenticating EncryptedPassportElement. See the Telegram Passport Documentation for a complete description of the data decryption and authentication processes.
 * @see <a href="https://core.telegram.org/bots/api#encryptedcredentials">EncryptedCredentials</a>
 */
@Introspected
public class EncryptedCredentials {

    /**
     * Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for EncryptedPassportElement decryption and authentication.
     */
    @Nonnull
    @NotBlank
    private String data;

    /**
     * Base64-encoded data hash for data authentication.
     */
    @Nonnull
    @NotBlank
    private String hash;

    /**
     * Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
     */
    @Nonnull
    @NotBlank
    private String secret;

    public EncryptedCredentials() {
    }

    @Nonnull
    public String getData() {
        return data;
    }

    public void setData(@Nonnull String data) {
        this.data = data;
    }

    @Nonnull
    public String getHash() {
        return hash;
    }

    public void setHash(@Nonnull String hash) {
        this.hash = hash;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "EncryptedCredentials{" +
                "data='" + data + '\'' +
                ", hash='" + hash + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
