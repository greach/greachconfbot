package io.micronaut.bots.telegram

import spock.lang.Specification

class ResponseParametersSpec extends Specification {
    void "ResponseParameters::toString() does not throw NPE"() {
        when:
        new ResponseParameters().toString()

        then:
        noExceptionThrown()
    }
}
