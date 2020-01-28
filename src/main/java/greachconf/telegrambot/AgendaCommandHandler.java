package greachconf.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import greachconf.agenda.Agenda;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaDay;
import io.micronaut.bots.telegram.CommandHandler;
import io.micronaut.bots.telegram.InlineKeyboardButton;
import io.micronaut.bots.telegram.InlineKeyboardMarkup;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Singleton
@Named(AgendaCommandHandler.COMMAND_AGENDA)
public class AgendaCommandHandler implements CommandHandler {
    public static final String COMMAND_AGENDA = "agenda";
    private static final Logger LOG = LoggerFactory.getLogger(AgendaCommandHandler.class);
    public static final String AGENDA = "Agenda:";

    private final AgendaApi agendaApi;
    private final ObjectMapper objectMapper;

    public AgendaCommandHandler(AgendaApi agendaApi, ObjectMapper objectMapper) {
        this.agendaApi = agendaApi;
        this.objectMapper = objectMapper;
    }

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        Integer chatId = update.getMessage().getChat().getId();
        return compose(configuration, String.valueOf(chatId));
    }

    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotBlank String chatId) {

        Agenda agenda = agendaApi.fetchAgenda().blockingGet();

        SendMessage keyboardMessage = new SendMessage();
        keyboardMessage.setChatId(chatId);
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        for (AgendaDay day : agenda.getDays()) {
            String data = DayCommandHandler.DATE_FORMATTER.format(day.getDay());
            InlineKeyboardButton btn = new InlineKeyboardButton();
            btn.setCallbackData(DayCommandHandler.COMMAND_PREFFIX + DayCommandHandler.COMMAND_DAY + " " + data);
            btn.setText(data);
            keyboard.add(Collections.singletonList(btn));
        }
        inlineKeyboardMarkup.setInlineKeyboard(keyboard);
        String json = serializeInlineKeyboardMarkup(inlineKeyboardMarkup, objectMapper, LOG);
        keyboardMessage.setText(AGENDA);
        keyboardMessage.setReplyMarkup(json);
        return Optional.of(Collections.singletonList(keyboardMessage));
    }

    @Override
    public String getCommandName() {
        return COMMAND_AGENDA;
    }
}
