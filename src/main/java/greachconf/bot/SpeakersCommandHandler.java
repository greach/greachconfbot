package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaTalkSpeaker;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Named(SpeakersCommandHandler.COMMAND_SPEAKERS)
public class SpeakersCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SpeakersCommandHandler.class);

    public static final String COMMAND_SPEAKERS = "speakers";

    protected final AgendaApi agendaApi;
    protected final SpeakersMessageComposer speakersMessageComposer;

    public SpeakersCommandHandler(AgendaApi agendaApi, SpeakersMessageComposer speakersMessageComposer) {
        this.agendaApi = agendaApi;
        this.speakersMessageComposer = speakersMessageComposer;
    }

    @Override
    public <T extends ChatBotMessageSend> Optional<T> handle(@NonNull ChatBot chatBot, @NonNull ChatBotMessageReceive messageReceive) {

        try {
            List<AgendaTalkSpeaker> speakers = this.agendaApi.fetchSpeakers().blockingGet();
            if (LOG.isInfoEnabled()) {
                LOG.info("fetched #{} speakers", speakers.size());
            }
            return (Optional) speakersMessageComposer.compose(speakers, messageReceive);
        } catch (HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching speakers", e);
            }
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("could not compose message for speakers");
        }
        return Optional.empty();
    }
}
