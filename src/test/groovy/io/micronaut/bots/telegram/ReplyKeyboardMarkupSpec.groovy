package io.micronaut.bots.telegram

import spock.lang.Specification

class ReplyKeyboardMarkupSpec extends Specification {
    void "ReplyKeyboardMarkup::toString() does not throw NPE"() {
        when:
        new ReplyKeyboardMarkup().toString()

        then:
        noExceptionThrown()
    }
}
