package io.micronaut.bots.telegram

import spock.lang.Specification

class ChosenInlineResultSpec extends Specification {
    void "ChosenInlineResult::toString() does not throw NPE"() {
        when:
        new ChosenInlineResult().toString()

        then:
        noExceptionThrown()
    }
}
