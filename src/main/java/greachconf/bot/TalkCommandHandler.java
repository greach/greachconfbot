package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.Talk;
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
import java.util.Optional;


@Named(TalkCommandHandler.COMMAND_TALK)
@Singleton
public class TalkCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(TalkCommandHandler.class);

    public static final String COMMAND_TALK = "talk";

    protected final TalkMessageComposer talkMessageComposer;
    protected final TelegramChatBotMessageParser messageParser;
    protected final AgendaApi agendaApi;

    public TalkCommandHandler(TalkMessageComposer talkMessageComposer,
                              TelegramChatBotMessageParser messageParser,
                              AgendaApi agendaApi) {
        this.talkMessageComposer = talkMessageComposer;
        this.messageParser = messageParser;
        this.agendaApi = agendaApi;
    }

    @Override
    public <T extends ChatBotMessageSend> Optional<T> handle(@NonNull ChatBot chatBot,
                                                             @NonNull ChatBotMessageReceive messageReceive) {

        Optional<String> textOptional = messageParser.parseText(messageReceive);
        if (!textOptional.isPresent()) {
            if (LOG.isInfoEnabled()) {
                LOG.info("parsed text is empty");
            }
            return Optional.empty();
        }
        String text = textOptional.get();
        String talkId = TextUtils.textAfterCommand(text, COMMAND_TALK);
        try {
            Talk talk = this.agendaApi.fetchTalkById(talkId).blockingGet();
            if (LOG.isInfoEnabled()) {
                LOG.info("fetched talk {}", talk.toString());
            }
            return (Optional) talkMessageComposer.compose(talk, chatBot, messageReceive);
        } catch (HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching speakers", e);
            }
        }
        if (LOG.isInfoEnabled()) {
            LOG.info("did not compose any message for talk {}", messageReceive.toString());
        }
        return Optional.empty();
    }
}
