package io.micronaut.bots.telegram;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class WebhookController {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookController.class);

    private final Map<String, TelegramBotConfiguration> configuration;
    private final UpdateHandler updateHandler;
    private final ObjectMapper objectMapper;

    public WebhookController(Collection<TelegramBotConfiguration> telegramBotConfigurationCollection,
                             UpdateHandler updateHandler,
                             ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.configuration = new HashMap<>();

        for (TelegramBotConfiguration conf : telegramBotConfigurationCollection) {
            this.configuration.put(conf.getToken(), conf);
        }
        this.updateHandler = updateHandler;
    }

    @Operation(operationId = "telegramWebhook",
            summary = "receive webhook telegram updates",
            parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "token", required = true, description = "telegram bot token"),
            },
            description = "receive webhook telegram updates",
            responses = {
                    @ApiResponse(responseCode = "200", description = "SendMessage after receiving a telegram update", content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SendMessage.class, type = "object")
                    )),
            }
    )
    @Post("/{token}")
    public HttpResponse update(@PathVariable String token,
                               @Body Update update) {
        if (!configuration.containsKey(token)) {
            return HttpResponse.unauthorized();
        }
        Optional<Send> opt = updateHandler.handleUpdate(configuration.get(token), update);

        if (!opt.isPresent()) {
            return HttpResponse.ok();
        }
        return HttpResponse.ok(opt.get());
    }
}