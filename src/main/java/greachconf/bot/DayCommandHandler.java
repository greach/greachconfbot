package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.Agenda;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaDay;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.bots.telegram.dispatcher.TelegramChatBotMessageParser;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Named(DayCommandHandler.COMMAND_DAY)
@Singleton
public class DayCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(DayCommandHandler.class);
    public static final String COMMAND_DAY = "day";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    protected final AgendaApi agendaApi;
    protected final TelegramChatBotMessageParser messageParser;
    protected final DayComposer dayComposer;

    public DayCommandHandler(AgendaApi agendaApi,
                             TelegramChatBotMessageParser messageParser,
                             DayComposer dayComposer) {
        this.agendaApi = agendaApi;
        this.messageParser = messageParser;
        this.dayComposer = dayComposer;
    }


    @Override
    public <T extends ChatBotMessageSend> Optional<T> handle(@NonNull ChatBot chatBot, @NonNull ChatBotMessageReceive update) {

        Optional<String> textOptional = messageParser.parseText(update);
        if (textOptional.isEmpty()) {
            if (LOG.isInfoEnabled()) {
                LOG.info("text parsed is empty");
            }
            return Optional.empty();
        }

        String text = textOptional.get();
        String textWithoutCommand = TextUtils.textAfterCommand(text, COMMAND_DAY);
        LocalDate d = LocalDate.parse(textWithoutCommand, DATE_FORMATTER);
        if (LOG.isInfoEnabled()) {
            LOG.info("parsed date {}", d.toString());
        }
        try {
            Agenda agenda = agendaApi.fetchAgenda().blockingGet();
            if (LOG.isInfoEnabled()) {
                LOG.info("fetched agenda");
            }

            for (AgendaDay day : agenda.getDays()) {
                if (!d.isEqual(day.getDay())) {
                    continue;
                }
                if (LOG.isInfoEnabled()) {
                    LOG.info("compose message for agenda day {}", day.toString());
                }
                return (Optional) dayComposer.compose(day, chatBot, update);
            }
            return (Optional) dayComposer.dayNotFound(d, chatBot, update);
        } catch(HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching agenda {}", e.getMessage());
            }
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("did not reply message for {}", update.toString());
        }
        return Optional.empty();
    }
}
