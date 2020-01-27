package io.micronaut.bots.telegram

import spock.lang.Specification

class InlineQuerySpec extends Specification {
    void "InlineQuery::toString() does not throw NPE"() {
        when:
        new InlineQuery().toString()

        then:
        noExceptionThrown()
    }
}
