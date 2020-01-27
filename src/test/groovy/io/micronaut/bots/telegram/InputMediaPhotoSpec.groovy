package io.micronaut.bots.telegram

import spock.lang.Specification

class InputMediaPhotoSpec extends Specification {
    void "InputMediaPhoto::toString() does not throw NPE"() {
        when:
        new InputMediaPhoto().toString()

        then:
        noExceptionThrown()
    }
}
