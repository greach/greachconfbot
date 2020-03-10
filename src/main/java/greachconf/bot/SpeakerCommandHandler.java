package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaTalkSpeaker;
import greachconf.agenda.Speaker;
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
import java.util.List;
import java.util.Optional;

@Named(SpeakerCommandHandler.COMMAND_SPEAKER)
@Singleton
public class SpeakerCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SpeakerCommandHandler.class);

    public static final String COMMAND_SPEAKER = "speaker";
    private final AgendaApi agendaApi;
    private final TelegramChatBotMessageParser messageParser;
    private final SpeakerMessageComposer speakerMessageComposer;

    public SpeakerCommandHandler(AgendaApi agendaApi,
                                 TelegramChatBotMessageParser messageParser,
                                 SpeakerMessageComposer speakerMessageComposer) {
        this.agendaApi = agendaApi;

        this.messageParser = messageParser;
        this.speakerMessageComposer = speakerMessageComposer;
    }

    @Override
    public <T extends ChatBotMessageSend> Optional<T> handle(@NonNull ChatBot chatBot, @NonNull ChatBotMessageReceive update) {
        try {

            Optional<String> textOptional = messageParser.parseText(update);
            if (!textOptional.isPresent()) {
                if (LOG.isInfoEnabled()) {
                    LOG.info("text parsed is empty");
                }
                return Optional.empty();
            }
            String text = textOptional.get();
            String textAfterCommand = TextUtils.textAfterCommand(text, COMMAND_SPEAKER);
            if (LOG.isInfoEnabled()) {
                LOG.info("text after command is {}", textAfterCommand);
            }
            List<AgendaTalkSpeaker> agendaTalkSpeakerList = this.agendaApi.fetchSpeakers().blockingGet();
            String selectedUid = null;
            for (AgendaTalkSpeaker agendaTalkSpeaker : agendaTalkSpeakerList) {
                if (textAfterCommand.contains(agendaTalkSpeaker.getUid()) || textAfterCommand.contains(agendaTalkSpeaker.getName())) {
                    selectedUid = agendaTalkSpeaker.getUid();
                    break;
                }
            }
            if (LOG.isInfoEnabled()) {
                LOG.info("parsed uid: {}", selectedUid);
            }
            if (selectedUid != null) {
                Speaker speaker = this.agendaApi.fetchSpeakerById(selectedUid).blockingGet();
                if (LOG.isInfoEnabled()) {
                    LOG.info("fetched speaker {}", speaker.toString());
                }
                speakerMessageComposer.sendMessagesForSpeaker(speaker, chatBot, update);
            }
        } catch (HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching speakers", e);
            }
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("could not compose a message for speaker {}" ,update.toString());
        }
        return Optional.empty();
    }
}
