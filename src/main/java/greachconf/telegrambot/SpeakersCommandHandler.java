package greachconf.telegrambot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaTalkSpeaker;
import io.micronaut.bots.telegram.CommandHandler;
import io.micronaut.bots.telegram.InlineKeyboardButton;
import io.micronaut.bots.telegram.InlineKeyboardMarkup;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.SendMessage;
import io.micronaut.bots.telegram.TelegramBotConfiguration;
import io.micronaut.bots.telegram.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Singleton
@Named(SpeakersCommandHandler.COMMAND_SPEAKERS)
public class SpeakersCommandHandler implements CommandHandler {
    public static final String COMMAND_SPEAKERS = "speakers";
    private static final Logger LOG = LoggerFactory.getLogger(SpeakersCommandHandler.class);
    public static final String SPEAKERS_MSG = "/speakers";
    public static final String GREACH_SPEAKERS = "Greach speakers:";

    private final ObjectMapper objectMapper;
    private final AgendaApi agendaApi;

    public SpeakersCommandHandler(ObjectMapper objectMapper,
                                  AgendaApi agendaApi) {
        this.objectMapper = objectMapper;
        this.agendaApi = agendaApi;
    }

    @Override
    public String getCommandName() {
        return COMMAND_SPEAKERS;
    }

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        Integer chatId = update.getMessage().getChat().getId();
        return compose(configuration, String.valueOf(chatId));
    }

    @Nonnull
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotBlank String chatId) {
        List<AgendaTalkSpeaker> speakers = this.agendaApi.fetchSpeakers().blockingGet();
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        for (AgendaTalkSpeaker speaker : speakers) {
            List<InlineKeyboardButton> speakerKeyboard = new ArrayList<>();
            speakerKeyboard.add(buttonForSpeaker(speaker));
            keyboard.add(speakerKeyboard);
        }
        inlineKeyboardMarkup.setInlineKeyboard(keyboard);
        String json = serializeInlineKeyboardMarkup(inlineKeyboardMarkup);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(GREACH_SPEAKERS);
        sendMessage.setReplyMarkup(json);

        return Optional.of(Collections.singletonList(sendMessage));
    }

    @Nullable
    private String serializeInlineKeyboardMarkup(@Nonnull InlineKeyboardMarkup inlineKeyboardMarkup) {
        try {
            return objectMapper.writeValueAsString(inlineKeyboardMarkup);
        } catch (JsonProcessingException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error generating serialized JSON of inlineKeyboard", e);
            }
        }
        return null;
    }

    private InlineKeyboardButton buttonForSpeaker(AgendaTalkSpeaker speaker) {
        InlineKeyboardButton btn = new InlineKeyboardButton();
        btn.setCallbackData(SpeakerCommandHandler.COMMAND_PREFFIX + SpeakerCommandHandler.COMMAND_SPEAKER + " " + speaker.getUid());
        btn.setText(speaker.getName());
        return btn;
    }
}
