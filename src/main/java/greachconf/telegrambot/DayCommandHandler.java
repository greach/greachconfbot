package greachconf.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import greachconf.agenda.Agenda;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaDay;
import greachconf.agenda.AgendaItem;
import greachconf.agenda.AgendaTalk;
import greachconf.agenda.AgendaTalkSpeaker;
import greachconf.agenda.AgendaTimeSlot;
import io.micronaut.bots.telegram.AnswerCallbackQuery;
import io.micronaut.bots.telegram.CallbackQuery;
import io.micronaut.bots.telegram.CallbackQueryHandler;
import io.micronaut.bots.telegram.CallbackQueryResponse;
import io.micronaut.bots.telegram.CommandHandler;
import io.micronaut.bots.telegram.InlineKeyboardButton;
import io.micronaut.bots.telegram.InlineKeyboardMarkup;
import io.micronaut.bots.telegram.MarkdownV2Builder;
import io.micronaut.bots.telegram.ParseMode;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.SendMessage;
import io.micronaut.bots.telegram.TelegramBotConfiguration;
import io.micronaut.bots.telegram.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named(DayCommandHandler.COMMAND_DAY)
@Singleton
public class DayCommandHandler implements CommandHandler, CallbackQueryHandler {
    private static final Logger LOG = LoggerFactory.getLogger(DayCommandHandler.class);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static final String COMMAND_DAY = "day";
    private final AgendaApi agendaApi;
    private final ObjectMapper objectMapper;

    public DayCommandHandler(AgendaApi agendaApi,
                             ObjectMapper objectMapper) {
        this.agendaApi = agendaApi;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<CallbackQueryResponse> handle(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                                  @Nonnull @NotNull @Valid CallbackQuery callbackQuery) {
        CallbackQueryResponse response = new CallbackQueryResponse();
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setCallbackQueryId(callbackQuery.getId());
        response.setAnswerCallbackQuery(answerCallbackQuery);
        Optional<List<Send>> messages = compose(String.valueOf(callbackQuery.getFrom().getId()), callbackQuery.getData());
        messages.ifPresent(response::setMessages);
        return Optional.of(response);
    }

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        String text = update.getMessage().getText();
        if (text == null) {
            return Optional.empty();
        }
        Integer chatId = update.getMessage().getChat().getId();
        return compose(String.valueOf(chatId), text);
    }

    public Optional<List<Send>> compose(String chatId,
                                        @Nonnull @NotBlank String text) {
        String textWithoutCommand = cleanupCommand(text);
        LocalDate day = LocalDate.parse(textWithoutCommand, DATE_FORMATTER);
        return sendMessageForDate(chatId, day).map(it -> Optional.of(Collections.singletonList(it))).orElse(Optional.empty());
    }

    Optional<Send> sendMessageForDate(String chatId, LocalDate d) {
        Agenda agenda = agendaApi.fetchAgenda().blockingGet();

        for (AgendaDay day : agenda.getDays()) {
            if (!d.isEqual(day.getDay())) {
                continue;
            }

            List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

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

                        InlineKeyboardButton btn = new InlineKeyboardButton();
                        btn.setCallbackData(TalkCommandHandler.COMMAND_PREFFIX + TalkCommandHandler.COMMAND_TALK + " " + talk.getUid());
                        btn.setText(talk.getTitle());
                        keyboard.add(Collections.singletonList(btn));


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



            SendMessage keyboardMessage = new SendMessage();
            keyboardMessage.setChatId(chatId);
            keyboardMessage.setText(builder.build());
            keyboardMessage.setParseMode(ParseMode.MARKDOWN.toString());

            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            inlineKeyboardMarkup.setInlineKeyboard(keyboard);
            String json = serializeInlineKeyboardMarkup(inlineKeyboardMarkup, objectMapper, LOG);
            keyboardMessage.setReplyMarkup(json);

            return Optional.of(keyboardMessage);
        }

        SendMessage dayNotFoundMessage = new SendMessage();
        dayNotFoundMessage.setText("Agenda day not found " +  DATE_FORMATTER.format(d));
        dayNotFoundMessage.setChatId(chatId);
        return Optional.of(dayNotFoundMessage);
    }

    @Override
    public String getCommandName() {
        return COMMAND_DAY;
    }
}
