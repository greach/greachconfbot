package io.micronaut.bots.telegram

import spock.lang.Specification

class PollSpec extends Specification {
    void "Poll::toString() does not throw NPE"() {
        when:
        new Poll().toString()

        then:
        noExceptionThrown()
    }
}
