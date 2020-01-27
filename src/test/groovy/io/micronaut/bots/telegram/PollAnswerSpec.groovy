package io.micronaut.bots.telegram

import spock.lang.Specification

class PollAnswerSpec extends Specification {
    void "PollAnswer::toString() does not throw NPE"() {
        when:
        new PollAnswer().toString()

        then:
        noExceptionThrown()
    }
}
