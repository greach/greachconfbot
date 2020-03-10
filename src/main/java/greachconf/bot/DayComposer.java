package greachconf.bot;

import greachconf.agenda.AgendaDay;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;

import java.time.LocalDate;
import java.util.Optional;

public interface DayComposer {
    Optional<ChatBotMessageSend> compose(AgendaDay day, ChatBot bot, ChatBotMessageReceive messageReceive);

    Optional<ChatBotMessageSend> dayNotFound(LocalDate d, ChatBot bot, ChatBotMessageReceive messageReceive);
}
