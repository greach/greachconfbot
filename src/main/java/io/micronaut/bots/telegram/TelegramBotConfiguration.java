package io.micronaut.bots.telegram;

import io.micronaut.core.naming.Named;
import io.micronaut.core.util.Toggleable;

import javax.annotation.Nonnull;
import java.util.List;

public interface TelegramBotConfiguration extends Named, Toggleable {

    @Nonnull
    String getToken();

    @Nonnull
    List<String> getCommands();
}
