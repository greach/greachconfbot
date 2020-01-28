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

@Named(HelpCommandHandler.COMMAND_HELP)
@Singleton
public class HelpCommandHandler implements CommandHandler {
    private static final Logger LOG = LoggerFactory.getLogger(HelpCommandHandler.class);
    public static final String COMMAND_HELP = "help";

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChat().getId());
        sendMessage.setText(message());
        return Optional.of(Collections.singletonList(sendMessage));
    }

    private String message() {
        MarkdownV2Builder builder = new MarkdownV2Builder();
        builder.text("I can can help you get the most out of Greach Conference").newLine().newLine();
        builder.text("You can control me by sending these commands:").newLine().newLine();
        builder.text("/"  + SpeakersCommandHandler.COMMAND_SPEAKERS + " - list of speakers").newLine();
        builder.text("/"  + AgendaCommandHandler.COMMAND_AGENDA + " - list of talks").newLine();
        builder.text("/venue - venue directions").newLine();
        builder.text("/today - today's agenda").newLine();
        builder.text("/next - information about the next time slots").newLine();
        builder.text("/"  + TalkCommandHandler.COMMAND_TALK + " talk-id - information about a talk").newLine();
        builder.text("/"  + DayCommandHandler.COMMAND_DAY + "  dd-MM-yyyy - agenda for a particular date").newLine();
        builder.text("/"  + SpeakerCommandHandler.COMMAND_SPEAKER + " speaker-id - information about one speaker").newLine();
        return builder.build();
    }

    @Override
    public String getCommandName() {
        return COMMAND_HELP;
    }
}
