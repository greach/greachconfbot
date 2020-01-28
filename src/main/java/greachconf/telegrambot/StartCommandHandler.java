package greachconf.telegrambot;


import io.micronaut.bots.telegram.CommandHandler;
import io.micronaut.bots.telegram.MarkdownV2Builder;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.SendMessage;
import io.micronaut.bots.telegram.TelegramBotConfiguration;
import io.micronaut.bots.telegram.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Named(StartCommandHandler.COMMAND_START)
@Singleton
public class StartCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(StartCommandHandler.class);
    public static final String COMMAND_START = "start";

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChat().getId());
        sendMessage.setText(new MarkdownV2Builder().bold("What can this bot do?").newLine().text("I am a bot to help you get the most out of Greach Conference. I can help you check the agenda, directions to the venue, information about speakers etc.").build());
        return Optional.of(Collections.singletonList(sendMessage));
    }

    @Override
    public String getCommandName() {
        return COMMAND_START;
    }
}
