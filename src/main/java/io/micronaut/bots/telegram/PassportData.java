package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Contains information about Telegram Passport data shared with the bot by the user.
 * @see <a href="https://core.telegram.org/bots/api#passportdata">PassportData</a>
 */
@Introspected
public class PassportData {
    /**
     * Array with information about documents and other Telegram Passport elements that was shared with the bot
     */
    private List<EncryptedPassportElement> data;

    /**
     * Encrypted credentials required to decrypt the data.
     */
    private EncryptedCredentials credentials;

    public PassportData() {
    }

    public List<EncryptedPassportElement> getData() {
        return data;
    }

    public void setData(List<EncryptedPassportElement> data) {
        this.data = data;
    }

    public EncryptedCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(EncryptedCredentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "PassportData{" +
                "data=" + (data != null ?  String.join(",",data.stream().map(EncryptedPassportElement::toString).collect(Collectors.toList())) : "") +
                ", credentials=" + (credentials !=null ? credentials.toString() : "") +
                '}';
    }
}
