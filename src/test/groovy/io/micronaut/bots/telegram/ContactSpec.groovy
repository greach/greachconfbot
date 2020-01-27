package io.micronaut.bots.telegram

import spock.lang.Specification

class ContactSpec extends Specification {
    void "Contact::toString() does not throw NPE"() {
        when:
        new Contact().toString()

        then:
        noExceptionThrown()
    }
}
