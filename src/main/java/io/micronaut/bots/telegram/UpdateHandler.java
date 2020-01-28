package io.micronaut.bots.telegram;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface UpdateHandler {

    @Nonnull
    Optional<Send> handleUpdate(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                @Nonnull @NotNull @Valid Update update);
}
