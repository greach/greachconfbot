package greachconf.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.bots.telegram.CallbackQuery;
import io.micronaut.bots.telegram.CallbackQueryHandler;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.TelegramBotConfiguration;

import javax.annotation.Nonnull;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Named(SpeakersCommandHandler.COMMAND_SPEAKERS)
@Singleton
public class SpeakersCallbackQueryHandler implements CallbackQueryHandler {

    private final SpeakerCommandHandler speakerCommandHandler;
    private final ObjectMapper objectMapper;

    public SpeakersCallbackQueryHandler(SpeakerCommandHandler speakerCommandHandler,
                                        ObjectMapper objectMapper) {
        this.speakerCommandHandler = speakerCommandHandler;
        this.objectMapper = objectMapper;
    }

    @Override
    public Optional<List<Send>> handle(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                       @Nonnull @NotNull @Valid CallbackQuery callbackQuery) {
        String speakerUid = callbackQuery.getData();
        return Optional.of(speakerCommandHandler.messagesForSpeakerUid(String.valueOf(callbackQuery.getFrom().getId()), speakerUid));
    }
}
