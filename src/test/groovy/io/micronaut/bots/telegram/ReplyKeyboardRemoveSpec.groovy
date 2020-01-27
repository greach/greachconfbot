package io.micronaut.bots.telegram

import spock.lang.Specification

class ReplyKeyboardRemoveSpec extends Specification {
    void "ReplyKeyboardRemove::toString() does not throw NPE"() {
        when:
        new ReplyKeyboardRemove().toString()

        then:
        noExceptionThrown()
    }
}
