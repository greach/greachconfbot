package io.micronaut.bots.telegram;

import io.micronaut.context.annotation.EachBean;
import io.micronaut.context.annotation.Factory;

@Factory
public class TelegramBotFactory {

    @EachBean(TelegramBotConfiguration.class)
    public TelegramBot buildTelegramBot(TelegramBotConfiguration configuration,
                                        TelegramApi telegramApi) {
        return new TelegramBot(configuration.getToken(), telegramApi);
    }
}
