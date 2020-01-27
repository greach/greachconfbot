package io.micronaut.bots.telegram

import spock.lang.Specification

class InlineKeyboardMarkupSpec extends Specification {
    void "InlineKeyboardMarkup::toString() does not throw NPE"() {
        when:
        new InlineKeyboardMarkup().toString()

        then:
        noExceptionThrown()
    }
}
