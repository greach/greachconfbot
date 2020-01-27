package io.micronaut.bots.telegram

import spock.lang.Specification

class ChatMemberSpec extends Specification {
    void "ChatMember::toString() does not throw NPE"() {
        when:
        new ChatMember().toString()

        then:
        noExceptionThrown()
    }
}
