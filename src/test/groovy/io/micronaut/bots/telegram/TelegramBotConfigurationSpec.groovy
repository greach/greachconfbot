package io.micronaut.bots.telegram

import greachconf.telegrambot.ApplicationContextSpecification
import io.micronaut.inject.qualifiers.Qualifiers
import spock.lang.Shared
import spock.lang.Subject

class TelegramBotConfigurationSpec extends ApplicationContextSpecification {

    @Subject
    @Shared
    TelegramBotConfiguration greachconf = applicationContext.getBean(TelegramBotConfiguration, Qualifiers.byName("greachconf"))

    void "commands are sorted largest commands first"() {
        expect:
        greachconf.getCommands() == ['speakers',
        'speaker']
    }
}
