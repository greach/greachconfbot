package io.micronaut.bots.telegram

import spock.lang.Specification

class EncryptedCredentialsSpec extends Specification {
    void "EncryptedCredentials::toString() does not throw NPE"() {
        when:
        new EncryptedCredentials().toString()

        then:
        noExceptionThrown()
    }
}
