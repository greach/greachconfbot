package greachconf.bot;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.Agenda;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import java.util.Optional;

public interface AgendaMessageComposer {
    Optional<ChatBotMessageSend> compose(@NonNull Agenda agenda, @NonNull ChatBot chatBot, @NonNull ChatBotMessageReceive messageReceive);

}
