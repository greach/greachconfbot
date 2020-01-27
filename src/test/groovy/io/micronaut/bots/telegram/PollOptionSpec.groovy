package io.micronaut.bots.telegram

import spock.lang.Specification

class PollOptionSpec extends Specification {
    void "PollOption::toString() does not throw NPE"() {
        when:
        new PollOption().toString()

        then:
        noExceptionThrown()
    }
}
