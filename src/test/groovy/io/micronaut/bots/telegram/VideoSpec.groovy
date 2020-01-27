package io.micronaut.bots.telegram

import spock.lang.Specification

class VideoSpec extends Specification {
    void "Video::toString() does not throw NPE"() {
        when:
        new Video().toString()

        then:
        noExceptionThrown()
    }
}
