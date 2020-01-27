package io.micronaut.bots.telegram

import spock.lang.Specification

class ShippingAddressSpec extends Specification {
    void "ShippingAddress::toString() does not throw NPE"() {
        when:
        new ShippingAddress().toString()

        then:
        noExceptionThrown()
    }
}
