package io.micronaut.bots.telegram

import spock.lang.Specification

class UpdateSpec extends Specification {

    void "Update::toString() does not throw NPE"() {
        when:
        new Update().toString()

        then:
        noExceptionThrown()
    }
}
