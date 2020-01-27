package io.micronaut.bots.telegram

import spock.lang.Specification

class MessageSpec extends Specification {
    void "Message::toString() does not throw NPE"() {
        when:
        new Message().toString()

        then:
        noExceptionThrown()
    }
}
