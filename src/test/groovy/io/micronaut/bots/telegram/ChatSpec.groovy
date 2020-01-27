package io.micronaut.bots.telegram

import spock.lang.Specification

class ChatSpec extends Specification {
    void "Chat::toString() does not throw NPE"() {
        when:
        new Chat().toString()

        then:
        noExceptionThrown()
    }
}
