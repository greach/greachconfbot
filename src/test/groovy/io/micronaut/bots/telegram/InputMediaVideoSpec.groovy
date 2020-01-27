package io.micronaut.bots.telegram

import spock.lang.Specification

class InputMediaVideoSpec extends Specification {
    void "InputMediaVideo::toString() does not throw NPE"() {
        when:
        new InputMediaVideo().toString()

        then:
        noExceptionThrown()
    }
}
