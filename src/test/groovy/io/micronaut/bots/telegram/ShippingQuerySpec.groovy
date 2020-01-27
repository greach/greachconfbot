package io.micronaut.bots.telegram

import spock.lang.Specification

class ShippingQuerySpec extends Specification {
    void "ShippingQuery::toString() does not throw NPE"() {
        when:
        new ShippingQuery().toString()

        then:
        noExceptionThrown()
    }
}
