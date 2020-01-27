package io.micronaut.bots.telegram

import spock.lang.Specification

class AnimationSpec extends Specification {
    void "Animation::toString() does not throw NPE"() {
        when:
        new Animation().toString()

        then:
        noExceptionThrown()
    }
}
