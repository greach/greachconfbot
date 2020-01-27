package io.micronaut.bots.telegram

import spock.lang.Specification

class LocationSpec extends Specification {
    void "Location::toString() does not throw NPE"() {
        when:
        new Location().toString()

        then:
        noExceptionThrown()
    }
}
