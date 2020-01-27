package io.micronaut.bots.telegram

import spock.lang.Specification

class InputMediaDocumentSpec extends Specification {
    void "InputMediaDocument::toString() does not throw NPE"() {
        when:
        new InputMediaDocument().toString()

        then:
        noExceptionThrown()
    }
}
