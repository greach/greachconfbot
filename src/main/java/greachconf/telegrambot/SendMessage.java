package greachconf.telegrambot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class SendMessage {

    @NotBlank
    private String method = "sendMessage";

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * Integer or String
     */
    @JsonProperty("chat_id")
    @NotNull
    private Object chatId;


    /**
     * Text of the message to be sent
     */
    @NotBlank
    private String text;

    public SendMessage() {

    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object getChatId() {
        return chatId;
    }

    public void setChatId(Object chatId) {
        this.chatId = chatId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}