package io.micronaut.bots.telegram

import spock.lang.Specification

class PassportDataSpec extends Specification {
    void "PassportData::toString() does not throw NPE"() {
        when:
        new PassportData().toString()

        then:
        noExceptionThrown()
    }
}
