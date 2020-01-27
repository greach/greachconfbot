package greachconf.telegrambot

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.bots.telegram.CommandHandler
import io.micronaut.bots.telegram.Send
import io.micronaut.bots.telegram.TelegramBotConfiguration
import io.micronaut.inject.qualifiers.Qualifiers
import spock.lang.Shared
import spock.lang.Subject

class SpeakersCommandHandlerSpec extends ApplicationContextSpecification {

    @Shared
    @Subject
    CommandHandler handler = applicationContext.getBean(CommandHandler, Qualifiers.byName("speakers"))

    void "there is a command handler bean qualified with name speakers"() {

        expect:
        handler instanceof SpeakersCommandHandler

        when:
        String chatId = "718074279"
        SpeakersCommandHandler speakersCommandHandler = (SpeakersCommandHandler) handler
        List<Send> sendList = speakersCommandHandler.compose(applicationContext.getBean(TelegramBotConfiguration, Qualifiers.byName("greachconf")),chatId).get()
        println applicationContext.getBean(ObjectMapper).writeValueAsString(sendList.get(0))

        then:
        noExceptionThrown()

    }


}
