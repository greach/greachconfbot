package io.micronaut.bots.telegram

import spock.lang.Specification

class OrderInfoSpec extends Specification {
    void "OrderInfo::toString() does not throw NPE"() {
        when:
        new OrderInfo().toString()

        then:
        noExceptionThrown()
    }
}
