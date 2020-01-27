package io.micronaut.bots.telegram

import spock.lang.Specification

class ChatPermissionsSpec extends Specification {
    void "ChatPermissions::toString() does not throw NPE"() {
        when:
        new ChatPermissions().toString()

        then:
        noExceptionThrown()
    }
}
