package io.micronaut.bots.telegram

import spock.lang.Specification

class VideoNoteSpec extends Specification {
    void "VideoNote::toString() does not throw NPE"() {
        when:
        new VideoNote().toString()

        then:
        noExceptionThrown()
    }
}
