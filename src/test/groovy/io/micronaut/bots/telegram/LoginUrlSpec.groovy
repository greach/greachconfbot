package io.micronaut.bots.telegram

import spock.lang.Specification

class LoginUrlSpec extends Specification {
    void "LoginUrl::toString() does not throw NPE"() {
        when:
        new LoginUrl().toString()

        then:
        noExceptionThrown()
    }
}
