package io.micronaut.bots.telegram

import spock.lang.Specification

class PassportFileSpec extends Specification {
    void "PassportFile::toString() does not throw NPE"() {
        when:
        new PassportFile().toString()

        then:
        noExceptionThrown()
    }
}
