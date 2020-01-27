package io.micronaut.bots.telegram

import spock.lang.Specification

class DocumentSpec extends Specification {
    void "Document::toString() does not throw NPE"() {
        when:
        new Document().toString()

        then:
        noExceptionThrown()
    }
}
