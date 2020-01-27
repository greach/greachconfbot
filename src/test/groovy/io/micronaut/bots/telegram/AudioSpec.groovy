package io.micronaut.bots.telegram

import spock.lang.Specification

class AudioSpec extends Specification {
    void "Audio::toString() does not throw NPE"() {
        when:
        new Audio().toString()

        then:
        noExceptionThrown()
    }
}
