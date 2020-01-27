package io.micronaut.bots.telegram

import spock.lang.Specification

class CallbackQuerySpec extends Specification {
    void "CallbackQuery::toString() does not throw NPE"() {
        when:
        new CallbackQuery().toString()

        then:
        noExceptionThrown()
    }
}
