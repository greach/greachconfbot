package greachconf.bot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.bots.core.ChatBotMessageDispatcher;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.telegram.core.Send;
import io.micronaut.bots.telegram.core.SendMessage;
import io.micronaut.bots.telegram.core.Update;
import io.micronaut.bots.telegram.httpclient.TelegramBot;
import io.micronaut.chatbots.telegram.httpserver.WebhookController;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Replaces(WebhookController.class)
@Controller
public class ReplacementWebhookController {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookController.class);

    private final Map<String, TelegramBot> configuration;
    private final ChatBotMessageDispatcher messageDispatcher;

    public ReplacementWebhookController(Collection<TelegramBot> telegramBots,
                             ChatBotMessageDispatcher messageDispatcher) {
        this.messageDispatcher = messageDispatcher;
        this.configuration = new HashMap<>();

        for (TelegramBot bot : telegramBots) {
            this.configuration.put(bot.getToken(), bot);
        }
    }

    @Post("/{token}")
    public HttpResponse update(@PathVariable String token,
                               @Body Update update) {
        if (!configuration.containsKey(token)) {
            if (LOG.isInfoEnabled()) {
                LOG.info("Configuration does not contain supplied token. rejected update {}", update.toString());
            }
            return HttpResponse.unauthorized();
        }

        Optional<ChatBotMessageSend> message = messageDispatcher.dispatch(configuration.get(token), update);
        if (message.isPresent()) {
            ChatBotMessageSend chatBotResponse = message.get();

            if (LOG.isInfoEnabled()) {
                LOG.info("Returning {}", chatBotResponse.toString());
            }
//            if (chatBotResponse instanceof SendMessage) {
//                greachconf.bot.SendMessage sendMessage = new greachconf.bot.SendMessage();
//                sendMessage.setParseMode(((SendMessage)chatBotResponse).getParseMode());
//                sendMessage.setDisableWebPagePreview(((SendMessage)chatBotResponse).getDisableWebPagePreview());
//                sendMessage.setText("foo" + ((SendMessage)chatBotResponse).getText());
//                sendMessage.setChatId(((SendMessage)chatBotResponse).getChatId());
//                sendMessage.setDisableNotification(((SendMessage)chatBotResponse).getDisableNotification());
//                sendMessage.setReplyMarkup(((SendMessage)chatBotResponse).getReplyMarkup());
//                sendMessage.setReplyToMessageId(((SendMessage)chatBotResponse).getReplyToMessageId());
//                return HttpResponse.ok(sendMessage);
//            }
            if (chatBotResponse instanceof io.micronaut.bots.telegram.core.Send) {
                io.micronaut.bots.telegram.core.Send send = ((Send) chatBotResponse);
                return HttpResponse.ok(send);
            }
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("Returning just 200 OK");
        }
        return HttpResponse.ok();
    }
}
