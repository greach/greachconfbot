package greachconf.telegrambot

import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class WebhookControllerSpec extends Specification {

    Map<String, Object> getConfiguration() {
        [:]
    }

    @AutoCleanup
    @Shared
    EmbeddedServer embeddedServer = ApplicationContext.run(EmbeddedServer, configuration)

    @Shared
    ApplicationContext applicationContext = embeddedServer.applicationContext

    @Shared
    HttpClient httpClient = applicationContext.createBean(HttpClient, embeddedServer.URL)

    @Shared
    BlockingHttpClient client = httpClient.toBlocking()

    void "/token responds sendMessage"() {

        when:
        HttpRequest request = HttpRequest.POST("/XXXYY", [message: [chat: [id: 123]]])
        HttpResponse<Map> response = client.exchange(request, Map)

        then:
        noExceptionThrown()
        response.status() == HttpStatus.OK

        when:
        Map m = response.body()

        then:
        m.method == "sendMessage"
        m.text == "haha"
        m.chat_id == 123
    }
}
