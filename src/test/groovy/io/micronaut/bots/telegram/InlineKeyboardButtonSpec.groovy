package io.micronaut.bots.telegram

import spock.lang.Specification

class InlineKeyboardButtonSpec extends Specification {
    void "InlineKeyboardButton::toString() does not throw NPE"() {
        when:
        new InlineKeyboardButton().toString()

        then:
        noExceptionThrown()
    }
}
