package io.micronaut.bots.telegram

import spock.lang.Specification

class StickerSpec extends Specification {
    void "Sticker::toString() does not throw NPE"() {
        when:
        new Sticker().toString()

        then:
        noExceptionThrown()
    }
}
