package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.AgendaTalkSpeaker;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;

import java.util.List;
import java.util.Optional;

public interface SpeakersMessageComposer {
    Optional<ChatBotMessageSend> compose(List<AgendaTalkSpeaker> speakers, @NonNull ChatBotMessageReceive messageReceive);
}
