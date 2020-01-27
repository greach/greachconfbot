package io.micronaut.bots.telegram

import spock.lang.Specification

class GameSpec extends Specification {
    void "Game::toString() does not throw NPE"() {
        when:
        new Game().toString()

        then:
        noExceptionThrown()
    }
}
