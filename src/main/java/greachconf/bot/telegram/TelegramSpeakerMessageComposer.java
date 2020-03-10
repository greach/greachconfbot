package greachconf.bot.telegram;

import greachconf.agenda.AgendaClient;
import greachconf.agenda.Speaker;
import greachconf.bot.SpeakerMessageComposer;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ParseMode;
import io.micronaut.bots.telegram.HtmlBuilder;
import io.micronaut.bots.telegram.core.SendMessage;
import io.micronaut.bots.telegram.core.SendPhoto;
import io.micronaut.bots.telegram.dispatcher.TelegramChatBotMessageParser;
import io.micronaut.bots.telegram.httpclient.MessageSent;
import io.micronaut.bots.telegram.httpclient.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class TelegramSpeakerMessageComposer implements SpeakerMessageComposer {
    protected final TelegramChatBotMessageParser messageParser;
    private static final Logger LOG = LoggerFactory.getLogger(TelegramSpeakerMessageComposer.class);


    public TelegramSpeakerMessageComposer(TelegramChatBotMessageParser messageParser) {
        this.messageParser = messageParser;
    }

    @Override
    public void sendMessagesForSpeaker(Speaker speaker, ChatBot bot, ChatBotMessageReceive messageReceive) {
        if (messageParser instanceof TelegramChatBotMessageParser) {
            Optional<Integer> chatIdOptional = ((TelegramChatBotMessageParser) messageParser).parseChatId(messageReceive);
            if (chatIdOptional.isPresent()) {
                Integer chatId = chatIdOptional.get();
                if (bot instanceof TelegramBot) {
                    TelegramBot telegramBot = (TelegramBot) bot;
                    MessageSent sentPhoto = telegramBot.sendPhoto(speakerSendPhoto(chatId, speaker)).blockingGet();
                    if (LOG.isInfoEnabled()) {
                        LOG.info("sent photo {}", sentPhoto.toString());
                    }
                    MessageSent sentMessage = telegramBot.sendMessage(speakerSendMessage(chatId, speaker)).blockingGet();
                    if (LOG.isInfoEnabled()) {
                        LOG.info("sent message {}", sentMessage.toString());
                    }
                }
            } else {
                if (LOG.isInfoEnabled()) {
                    LOG.info("could not parse chat id");
                }
            }
        } else {
            if (LOG.isInfoEnabled()) {
                LOG.info("messageParser not of TelegramChatBotMessageParser");
            }
        }
    }

    private SendPhoto speakerSendPhoto(Integer chatId, Speaker speaker) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setCaption(speaker.getName());
        sendPhoto.setPhoto(AgendaClient.GREACH_URL + speaker.getImage());
        return sendPhoto;
    }

    private SendMessage speakerSendMessage(Integer chatId, Speaker speaker) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(htmlForSpeaker(speaker));
        sendMessage.setDisableWebPagePreview(true);
        sendMessage.setParseMode(ParseMode.HTML.toString());
        return sendMessage;
    }

    private String htmlForSpeaker(Speaker speaker) {
        HtmlBuilder builder = new HtmlBuilder();
        if (speaker.getBio() != null) {
            for (String paragraph : speaker.getBio()) {
                builder = builder.text(HtmlBuilder.cleanupUnsupportedHtmlTags(paragraph)).newLine();
            }
        }
        return builder.build();
    }
}
