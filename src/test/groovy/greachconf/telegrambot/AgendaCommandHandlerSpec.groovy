package greachconf.telegrambot

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.bots.telegram.CommandHandler
import io.micronaut.bots.telegram.Send
import io.micronaut.bots.telegram.TelegramBotConfiguration
import io.micronaut.inject.qualifiers.Qualifiers
import spock.lang.Shared
import spock.lang.Subject


class AgendaCommandHandlerSpec extends ApplicationContextSpecification {

    @Shared
    @Subject
    CommandHandler commandHandler = applicationContext.getBean(CommandHandler, Qualifiers.byName("agenda"))

    void "foo"() {
        expect:
        commandHandler instanceof AgendaCommandHandler
        when:
        AgendaCommandHandler agendaCommandHandler = (AgendaCommandHandler) commandHandler
        String chatId = "718074279";
        Optional<List<Send>> listOptional = agendaCommandHandler.compose(applicationContext.getBean(TelegramBotConfiguration, Qualifiers.byName("greachconf")), chatId)

        for (Send s : listOptional.get()) {
            println("")
            println("")
            println applicationContext.getBean(ObjectMapper).writeValueAsString(s)
            println("")
            println("")
        }

        then:
        noExceptionThrown()
    }
}
