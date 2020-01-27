package io.micronaut.bots.telegram

import spock.lang.Specification

class PreCheckoutQuerySpec extends Specification {
    void "PreCheckoutQuery::toString() does not throw NPE"() {
        when:
        new PreCheckoutQuery().toString()

        then:
        noExceptionThrown()
    }
}
