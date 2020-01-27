package io.micronaut.bots.telegram

import spock.lang.Specification

class SuccessfulPaymentSpec extends Specification {
    void "SuccessfulPayment::toString() does not throw NPE"() {
        when:
        new SuccessfulPayment().toString()

        then:
        noExceptionThrown()
    }
}
