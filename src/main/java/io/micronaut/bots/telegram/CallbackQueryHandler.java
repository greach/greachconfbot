package io.micronaut.bots.telegram;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface CallbackQueryHandler {

    Optional<List<Send>> handle(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                @Nonnull @NotNull @Valid CallbackQuery callbackQuery);
}
