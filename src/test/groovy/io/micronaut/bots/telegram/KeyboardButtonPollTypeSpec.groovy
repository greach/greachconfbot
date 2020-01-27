package io.micronaut.bots.telegram

import spock.lang.Specification

class KeyboardButtonPollTypeSpec extends Specification {
    void "KeyboardButtonPollType::toString() does not throw NPE"() {
        when:
        new KeyboardButtonPollType().toString()

        then:
        noExceptionThrown()
    }
}
