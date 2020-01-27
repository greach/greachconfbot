package greachconf.telegrambot

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.bots.telegram.CommandHandler
import io.micronaut.bots.telegram.Send
import io.micronaut.bots.telegram.SendMessage
import io.micronaut.bots.telegram.SendPhoto
import io.micronaut.bots.telegram.TelegramBot
import io.micronaut.inject.qualifiers.Qualifiers
import spock.lang.Ignore

class SpeakerCommandHandlerSpec extends ApplicationContextSpecification {

    CommandHandler replyComposer = applicationContext.getBean(CommandHandler, Qualifiers.byName("speaker"))

    @Ignore
    void "it is possible to send speaker command"() {

        expect:
        replyComposer instanceof SpeakerCommandHandler
        when:
        SpeakerCommandHandler speakerReplyComposer = (SpeakerCommandHandler) replyComposer
        String chatId = "718074279"
        List<Send> responses = speakerReplyComposer.compose(chatId, "/speaker alvaro-sanchez-mariscal").get()

        TelegramBot telegramBot = applicationContext.getBean(TelegramBot, Qualifiers.byName("greachconf"))
        for (Send send : responses) {
            if (send instanceof SendMessage) {
                SendMessage sendMessage = (SendMessage) send
                println applicationContext.getBean(ObjectMapper).writeValueAsString(sendMessage)
                telegramBot.sendMessage(sendMessage).blockingGet()
            } else if (send instanceof SendPhoto) {
                SendPhoto sendPhoto = (SendPhoto) send
                println applicationContext.getBean(ObjectMapper).writeValueAsString(sendPhoto)
                telegramBot.sendPhoto(sendPhoto).blockingGet()
            }
        }

        then:
        noExceptionThrown()




    }

}
