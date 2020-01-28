package io.micronaut.bots.telegram;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface CallbackQueryHandler {

    Optional<CallbackQueryResponse> handle(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                @Nonnull @NotNull @Valid CallbackQuery callbackQuery);
}
