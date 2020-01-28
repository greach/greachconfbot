package io.micronaut.bots.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface CommandHandler {

    String COMMAND_PREFFIX = "/";

    @Nonnull
    Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                 @Nonnull @NotNull @Valid Update update);

    String getCommandName();

    default String cleanupCommand(String text) {
        return text.replaceAll(COMMAND_PREFFIX + getCommandName(), "").trim();
    }

    default String cleanupUnsupportedHtmlTags(String text) {
        String result = text;
        for (String tag : HtmlStyle.HTML_TAGS) {
            if (HtmlStyle.TELEGRAM_SUPPORTED_TAGS.contains(tag)) {
                continue;
            }
            result = result.replaceAll("<" + tag + ">", "").replaceAll("</" + tag + ">", "");
        }
        return result;
    }


    @Nullable
    default String serializeInlineKeyboardMarkup(@Nonnull InlineKeyboardMarkup inlineKeyboardMarkup,
                                                 @Nonnull ObjectMapper objectMapper,
                                                 @Nonnull Logger logger) {
        try {
            return objectMapper.writeValueAsString(inlineKeyboardMarkup);
        } catch (JsonProcessingException e) {
            if (logger.isErrorEnabled()) {
                logger.error("error generating serialized JSON of inlineKeyboard", e);
            }
        }
        return null;
    }
}
