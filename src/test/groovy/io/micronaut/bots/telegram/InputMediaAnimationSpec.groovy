package io.micronaut.bots.telegram

import spock.lang.Specification

class InputMediaAnimationSpec extends Specification {
    void "InputMediaAnimation::toString() does not throw NPE"() {
        when:
        new InputMediaAnimation().toString()

        then:
        noExceptionThrown()
    }
}
