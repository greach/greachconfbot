package io.micronaut.bots.telegram

import spock.lang.Specification

class UserProfilePhotosSpec extends Specification {
    void "UserProfilePhotos::toString() does not throw NPE"() {
        when:
        new UserProfilePhotos().toString()

        then:
        noExceptionThrown()
    }
}
