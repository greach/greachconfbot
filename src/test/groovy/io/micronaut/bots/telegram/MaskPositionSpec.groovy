package io.micronaut.bots.telegram

import spock.lang.Specification

class MaskPositionSpec extends Specification {
    void "MaskPosition::toString() does not throw NPE"() {
        when:
        new MaskPosition().toString()

        then:
        noExceptionThrown()
    }
}
