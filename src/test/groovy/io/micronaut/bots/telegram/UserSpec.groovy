package io.micronaut.bots.telegram

import spock.lang.Specification

class UserSpec extends Specification {
    void "User::toString() does not throw NPE"() {
        when:
        new User().toString()

        then:
        noExceptionThrown()
    }
}
