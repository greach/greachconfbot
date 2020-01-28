package io.micronaut.bots.telegram

import greachconf.telegrambot.ApplicationContextSpecification
import io.micronaut.inject.qualifiers.Qualifiers
import spock.lang.Shared
import spock.lang.Subject

import java.util.stream.Collectors

class TelegramBotConfigurationSpec extends ApplicationContextSpecification {

    @Subject
    @Shared
    TelegramBotConfiguration greachconf = applicationContext.getBean(TelegramBotConfiguration, Qualifiers.byName("greachconf"))

    void "commands are sorted largest commands first"() {
        when:
        List<String> l = greachconf.getCommands().stream().sorted(DefaultUpdateHandler.COMMANDS_COMPARATORS).collect(Collectors.toList())

        then:
        l == [
                'speakers',
                'speaker',
                'agenda',
                'start',
                'venue',
                'help',
                'next',
                'talk',
                'day'

        ]
    }
}
