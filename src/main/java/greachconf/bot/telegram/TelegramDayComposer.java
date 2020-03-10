package greachconf.bot.telegram;

import greachconf.agenda.AgendaDay;
import greachconf.agenda.AgendaItem;
import greachconf.agenda.AgendaTalk;
import greachconf.agenda.AgendaTalkSpeaker;
import greachconf.agenda.AgendaTimeSlot;
import greachconf.bot.DayComposer;
import greachconf.bot.TalkCommandHandler;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.bots.core.ParseMode;
import io.micronaut.bots.telegram.MarkdownV2Builder;
import io.micronaut.bots.telegram.core.InlineKeyboardButton;
import io.micronaut.bots.telegram.core.InlineKeyboardMarkup;
import io.micronaut.bots.telegram.core.SendMessage;
import io.micronaut.bots.telegram.dispatcher.TelegramChatBotMessageParser;
import io.micronaut.context.annotation.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static greachconf.bot.DayCommandHandler.DATE_FORMATTER;

@Requires(classes = InlineKeyboardButton.class)
@Singleton
public class TelegramDayComposer implements DayComposer {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramDayComposer.class);

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    protected final KeyboardMessageComposer keyboardMessageComposer;
    protected final TelegramChatBotMessageParser messageParser;

    public TelegramDayComposer(KeyboardMessageComposer keyboardMessageComposer,
                               TelegramChatBotMessageParser messageParser) {
        this.keyboardMessageComposer = keyboardMessageComposer;
        this.messageParser = messageParser;
    }

    @Override
    public Optional<ChatBotMessageSend> dayNotFound(LocalDate d, ChatBot bot, ChatBotMessageReceive messageReceive) {
        if (messageParser instanceof TelegramChatBotMessageParser) {
            Optional<Integer> chatIdOptional = ((TelegramChatBotMessageParser) messageParser).parseChatId(messageReceive);
            if (chatIdOptional.isPresent()) {
                Integer chatId = chatIdOptional.get();
                SendMessage dayNotFoundMessage = new SendMessage();
                dayNotFoundMessage.setText("Agenda day not found " + DATE_FORMATTER.format(d));
                dayNotFoundMessage.setChatId(chatId);
                if (LOG.isInfoEnabled()) {
                    LOG.info("sending message {}", dayNotFoundMessage.toString());
                }
                return Optional.of(dayNotFoundMessage);
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

    @Override
    public Optional<ChatBotMessageSend> compose(AgendaDay day, ChatBot bot, ChatBotMessageReceive messageReceive) {
        if (messageParser instanceof TelegramChatBotMessageParser) {
            Optional<Integer> chatIdOptional = ((TelegramChatBotMessageParser) messageParser).parseChatId(messageReceive);
            if (chatIdOptional.isPresent()) {
                Integer chatId = chatIdOptional.get();
                SendMessage keyboardMessage = new SendMessage();
                keyboardMessage.setChatId(chatId);
                String text = markdownForDay(day);
                keyboardMessage.setText(text);
                keyboardMessage.setParseMode(ParseMode.MARKDOWN.toString());
                InlineKeyboardMarkup inlineKeyboardMarkup = inlineKeyboardMarkupForDay(bot, day);
                keyboardMessageComposer.serializeInlineKeyboardMarkup(inlineKeyboardMarkup).ifPresent(keyboardMessage::setReplyMarkup);
                if (LOG.isInfoEnabled()) {
                    LOG.info("sending message {}", keyboardMessage.toString());
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

    private InlineKeyboardMarkup inlineKeyboardMarkupForDay(ChatBot bot, AgendaDay day) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        for (AgendaTimeSlot slot : day.getTimeSlots()) {
            if (slot.getTrackTalks() != null) {
                for (String track : slot.getTrackTalks().keySet()) {
                    AgendaTalk talk = slot.getTrackTalks().get(track);
                    InlineKeyboardButton btn = new InlineKeyboardButton();
                    btn.setCallbackData(bot.getAtUsername() + " " + CommandHandler.COMMAND_PREFIX + TalkCommandHandler.COMMAND_TALK + " " + talk.getUid());
                    btn.setText(talk.getTitle());
                    keyboard.add(Collections.singletonList(btn));
                }
            }
        }
        inlineKeyboardMarkup.setInlineKeyboard(keyboard);
        return inlineKeyboardMarkup;
    }

    private String markdownForDay(AgendaDay day) {
        MarkdownV2Builder builder = new MarkdownV2Builder();

        String formattedDate = day.getDay().format(DATE_FORMATTER);
        builder.bold(formattedDate).newLine().newLine();
        for (AgendaTimeSlot slot : day.getTimeSlots()) {
            String timeText = slot.getTimeSlot().getStart().format(TIME_FORMATTER) + " - " + slot.getTimeSlot().getEnd().format(TIME_FORMATTER);
            if (slot.getTrackTalks() != null) {
                for (String track : slot.getTrackTalks().keySet()) {
                    AgendaTalk talk = slot.getTrackTalks().get(track);
                    builder.text(timeText + " " + track + " ").newLine();
                    builder.text(talk.getTitle()).newLine();
                    builder.text(String.join(", ", talk.getSpeakers().stream().map(AgendaTalkSpeaker::getName).collect(Collectors.toList())));
                    builder.newLine();
                    builder.newLine();
                }
            }
            if (slot.getItems() != null) {
                for (AgendaItem item : slot.getItems()) {
                    builder.text(timeText + " " +  item.getTitle());
                    builder.newLine();
                    builder.newLine();

                }
            }
        }
        builder.newLine();
        builder.newLine();
        builder.newLine();
        return builder.build();
    }
}
