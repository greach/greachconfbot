package io.micronaut.bots.telegram

import spock.lang.Specification

class InvoiceSpec extends Specification {
    void "Invoice::toString() does not throw NPE"() {
        when:
        new Invoice().toString()

        then:
        noExceptionThrown()
    }
}
