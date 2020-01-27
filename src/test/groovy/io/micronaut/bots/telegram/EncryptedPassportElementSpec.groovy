package io.micronaut.bots.telegram

import spock.lang.Specification

class EncryptedPassportElementSpec extends Specification {
    void "EncryptedPassportElement::toString() does not throw NPE"() {
        when:
        new EncryptedPassportElement().toString()

        then:
        noExceptionThrown()
    }
}
