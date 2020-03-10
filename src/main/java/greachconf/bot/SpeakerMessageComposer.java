package greachconf.bot;

import greachconf.agenda.Speaker;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageReceive;

public interface SpeakerMessageComposer {
    void sendMessagesForSpeaker(Speaker speaker, ChatBot bot, ChatBotMessageReceive messageReceive);
}
