package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.Talk;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;

import javax.validation.Valid;
import java.util.Optional;

public interface TalkMessageComposer {

    Optional<ChatBotMessageSend> compose(@NonNull @Valid Talk talk,
                                         @NonNull ChatBot chatBot,
                                         @NonNull ChatBotMessageReceive messageReceive);
}
