package io.micronaut.bots.telegram

import spock.lang.Specification

class MessageEntitySpec extends Specification {
    void "MessageEntity::toString() does not throw NPE"() {
        when:
        new MessageEntity().toString()

        then:
        noExceptionThrown()
    }
}
