package io.micronaut.bots.telegram

import spock.lang.Specification

class PhotoSizeSpec extends Specification {
    void "PhotoSize::toString() does not throw NPE"() {
        when:
        new PhotoSize().toString()

        then:
        noExceptionThrown()
    }
}
