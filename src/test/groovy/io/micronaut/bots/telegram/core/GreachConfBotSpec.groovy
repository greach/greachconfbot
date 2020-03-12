package io.micronaut.bots.telegram.core

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Ignore
import spock.lang.Shared
import spock.lang.Specification

@Ignore
class GreachConfBotSpec extends Specification {

    @Shared
    @AutoCleanup
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer, [
            'telegram.bots.greachconf.token': 'XXX'
    ])

    @Shared
    ApplicationContext applicationContext = embeddedServer.applicationContext

    @Shared
    HttpClient httpClient = applicationContext.createBean(HttpClient,embeddedServer.URL)

    @Shared
    BlockingHttpClient client = httpClient.toBlocking()

    void "possible to send a JSON update"() {
        given:
        String json = '''
{
    "update_id": 44388804,
    "message": {
        "message_id": 786,
        "from": {
            "id": 718074279,
            "is_bot": false,
            "first_name": "Sergio",
            "last_name": "Del Amo",
            "language_code": "en"
        },
        "chat": {
            "id": 718074279,
            "first_name": "Sergio",
            "last_name": "Del Amo",
            "type": "private"
        },
        "date": 1583917144,
        "text": "hola"
    }
}
'''
        when:
        HttpResponse<SendMessage> resp = client.exchange(HttpRequest.POST('/XXX', json), SendMessage)

        then:
        noExceptionThrown()

        resp.status() == HttpStatus.OK

        when:
        SendMessage message = resp.body()

        then:
        message.method == 'sendMessage'
        message.chatId
        message.text == "I don't understand. Please type /help"
    }
}
