package io.micronaut.bots.telegram

import spock.lang.Specification

class KeyboardButtonSpec extends Specification {
    void "KeyboardButton::toString() does not throw NPE"() {
        when:
        new KeyboardButton().toString()

        then:
        noExceptionThrown()
    }
}
