package greachconf.bot.telegram;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.AgendaTalkSpeaker;
import greachconf.bot.SpeakersMessageComposer;
import greachconf.bot.SpeakerCommandHandler;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.bots.telegram.core.InlineKeyboardButton;
import io.micronaut.bots.telegram.core.InlineKeyboardMarkup;
import io.micronaut.bots.telegram.core.SendMessage;
import io.micronaut.bots.telegram.dispatcher.TelegramChatBotMessageParser;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Requires(classes = InlineKeyboardButton.class)
@Singleton
public class TelegramSpeakersMessageComposer implements SpeakersMessageComposer {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramSpeakerMessageComposer.class);

    public static final String GREACH_SPEAKERS = "Greach speakers:";

    protected final TelegramChatBotMessageParser messageParser;
    protected final KeyboardMessageComposer keyboardMessageComposer;

    public TelegramSpeakersMessageComposer(TelegramChatBotMessageParser messageParser, KeyboardMessageComposer keyboardMessageComposer) {
        this.messageParser = messageParser;
        this.keyboardMessageComposer = keyboardMessageComposer;
    }

    @Override
    public Optional<ChatBotMessageSend> compose(List<AgendaTalkSpeaker> speakers, @NonNull ChatBotMessageReceive messageReceive) {
        if (messageParser instanceof TelegramChatBotMessageParser) {
            Optional<Integer> chatIdOptional = ((TelegramChatBotMessageParser) messageParser).parseChatId(messageReceive);
            if (chatIdOptional.isPresent()) {
                Integer chatId = chatIdOptional.get();

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(GREACH_SPEAKERS);
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                for (AgendaTalkSpeaker speaker : speakers) {
                    List<InlineKeyboardButton> speakerKeyboard = new ArrayList<>();
                    speakerKeyboard.add(buttonForSpeaker(speaker));
                    keyboard.add(speakerKeyboard);
                }
                inlineKeyboardMarkup.setInlineKeyboard(keyboard);
                keyboardMessageComposer.serializeInlineKeyboardMarkup(inlineKeyboardMarkup).ifPresent(sendMessage::setReplyMarkup);
                if (LOG.isInfoEnabled()) {
                    LOG.info("replying message {}", sendMessage.toString());
                }
                return Optional.of(sendMessage);
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
        return Optional.empty();
    }

    private InlineKeyboardButton buttonForSpeaker(AgendaTalkSpeaker speaker) {
        InlineKeyboardButton btn = new InlineKeyboardButton();
        btn.setCallbackData(CommandHandler.COMMAND_PREFIX + SpeakerCommandHandler.COMMAND_SPEAKER + " " + speaker.getUid());
        btn.setText(speaker.getName());
        return btn;
    }
}
