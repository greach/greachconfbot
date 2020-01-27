package io.micronaut.bots.telegram

import spock.lang.Specification

class VoiceSpec extends Specification {
    void "Voice::toString() does not throw NPE"() {
        when:
        new Voice().toString()

        then:
        noExceptionThrown()
    }
}
