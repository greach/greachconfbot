package io.micronaut.bots.telegram

import spock.lang.Specification

class ChatPhotoSpec extends Specification {
    void "ChatPhoto::toString() does not throw NPE"() {
        when:
        new ChatPhoto().toString()

        then:
        noExceptionThrown()
    }
}
