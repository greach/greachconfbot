package greachconf.bot.telegram;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.Agenda;
import greachconf.agenda.AgendaDay;
import greachconf.bot.AgendaMessageComposer;
import greachconf.bot.DayCommandHandler;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageParser;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.bots.telegram.core.InlineKeyboardButton;
import io.micronaut.bots.telegram.core.InlineKeyboardMarkup;
import io.micronaut.bots.telegram.core.SendMessage;
import io.micronaut.bots.telegram.dispatcher.TelegramChatBotMessageParser;
import io.micronaut.context.annotation.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Requires(classes = InlineKeyboardButton.class)
@Singleton
public class TelegramAgendaMessageComposer implements AgendaMessageComposer {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramAgendaMessageComposer.class);
    public static final String AGENDA = "Agenda:";

    protected final ChatBotMessageParser messageParser;
    protected final KeyboardMessageComposer keyboardMessageComposer;

    public TelegramAgendaMessageComposer(ChatBotMessageParser messageParser,
                                       KeyboardMessageComposer keyboardMessageComposer) {
        this.messageParser = messageParser;
        this.keyboardMessageComposer = keyboardMessageComposer;
    }

    @Override
    public Optional<ChatBotMessageSend> compose(@NonNull Agenda agenda, @NonNull ChatBot chatBot, @NonNull ChatBotMessageReceive messageReceive) {
        if (messageParser instanceof TelegramChatBotMessageParser) {
            Optional<Integer> chatIdOptional = ((TelegramChatBotMessageParser) messageParser).parseChatId(messageReceive);
            if (chatIdOptional.isPresent()) {
                Integer chatId = chatIdOptional.get();
                SendMessage keyboardMessage = new SendMessage();
                keyboardMessage.setChatId(chatId);
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
                for (AgendaDay day : agenda.getDays()) {
                    String data = DayCommandHandler.DATE_FORMATTER.format(day.getDay());
                    InlineKeyboardButton btn = new InlineKeyboardButton();
                    btn.setCallbackData(chatBot.getAtUsername() + " " + CommandHandler.COMMAND_PREFIX + DayCommandHandler.COMMAND_DAY + " " + data);
                    btn.setText(data);
                    keyboard.add(Collections.singletonList(btn));
                }
                inlineKeyboardMarkup.setInlineKeyboard(keyboard);
                keyboardMessage.setText(AGENDA);
                keyboardMessageComposer.serializeInlineKeyboardMarkup(inlineKeyboardMarkup).ifPresent(keyboardMessage::setReplyMarkup);
                if (LOG.isInfoEnabled()) {
                    LOG.info("responding message {}", keyboardMessage.toString());
                }
                return Optional.of(keyboardMessage);
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
}
