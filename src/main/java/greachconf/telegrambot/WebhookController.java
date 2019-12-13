package greachconf.telegrambot;

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
import java.util.Map;

@Controller
public class WebhookController {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookController.class);

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
    public SendMessage update(@PathVariable String token,
                         @Body Map<String, Object> update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setMethod("sendMessage");
        sendMessage.setText("haha");
        if (update.containsKey("message") &&
                update.get("message") instanceof Map &&
                ((Map) update.get("message")).containsKey("chat") &&
                ((Map) update.get("message")).get("chat") instanceof Map &&
                ((Map) ((Map) update.get("message")).get("chat")).containsKey("id")) {
            Object chatId = ((Map) ((Map) update.get("message")).get("chat")).get("id");
            sendMessage.setChatId(chatId);
        }
        return sendMessage;
    }
}
