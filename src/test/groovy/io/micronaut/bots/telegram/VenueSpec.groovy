package io.micronaut.bots.telegram

import spock.lang.Specification

class VenueSpec extends Specification {
    void "Venue::toString() does not throw NPE"() {
        when:
        new Venue().toString()

        then:
        noExceptionThrown()
    }
}
