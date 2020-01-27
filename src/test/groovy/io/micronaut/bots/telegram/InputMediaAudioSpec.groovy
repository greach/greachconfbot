package io.micronaut.bots.telegram

import spock.lang.Specification

class InputMediaAudioSpec extends Specification {
    void "InputMediaAudio::toString() does not throw NPE"() {
        when:
        new InputMediaAudio().toString()

        then:
        noExceptionThrown()
    }
}
