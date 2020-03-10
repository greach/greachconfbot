package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.Agenda;
import greachconf.agenda.AgendaApi;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
@Named(AgendaCommandHandler.COMMAND_AGENDA)
public class AgendaCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(AgendaCommandHandler.class);
    public static final String COMMAND_AGENDA = "agenda";

    protected final AgendaApi agendaApi;
    protected final AgendaMessageComposer agendaMessageComposer;

    public AgendaCommandHandler(AgendaApi agendaApi, AgendaMessageComposer agendaMessageComposer) {
        this.agendaApi = agendaApi;
        this.agendaMessageComposer = agendaMessageComposer;
    }

    @Override
    public <T extends ChatBotMessageSend> Optional<T> handle(@NonNull ChatBot chatBot, @NonNull ChatBotMessageReceive update) {
        try {
            Agenda agenda = agendaApi.fetchAgenda().blockingGet();
            if (LOG.isInfoEnabled()) {
                LOG.info("fetched agenda");
            }
            return (Optional) agendaMessageComposer.compose(agenda, chatBot, update);
        } catch (HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching speakers", e);
            }
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("could not create message for agenda command");
        }
        return Optional.empty();
    }
}
