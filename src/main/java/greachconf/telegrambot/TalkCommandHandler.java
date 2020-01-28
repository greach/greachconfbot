package greachconf.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import greachconf.agenda.Agenda;
import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaDay;
import greachconf.agenda.AgendaTalk;
import greachconf.agenda.AgendaTimeSlot;
import greachconf.agenda.Talk;
import io.micronaut.bots.telegram.HtmlBuilder;
import io.micronaut.bots.telegram.ParseMode;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Named(TalkCommandHandler.COMMAND_TALK)
@Singleton
public class TalkCommandHandler extends AbstractCommandAndCallbackHandler {
    private static final Logger LOG = LoggerFactory.getLogger(TalkCommandHandler.class);

    public static final String COMMAND_TALK = "talk";

    private final ObjectMapper objectMapper;

    private final AgendaApi agendaApi;

    public TalkCommandHandler(ObjectMapper objectMapper,
                              AgendaApi agendaApi) {
        this.objectMapper = objectMapper;
        this.agendaApi = agendaApi;
    }

    @Override
    public String getCommandName() {
        return COMMAND_TALK;
    }

    @Override
    @Nonnull
    public Optional<List<Send>> compose(@Nonnull @NotBlank String chatId, @Nonnull @NotBlank String text) {
        String textWithoutCommand = cleanupCommand(text);
        Agenda agenda = this.agendaApi.fetchAgenda().blockingGet();
        for (AgendaDay day : agenda.getDays()) {
            for (AgendaTimeSlot agendaTimeSlot : day.getTimeSlots()) {
                for (AgendaTalk talk : agendaTimeSlot.getTrackTalks().values()) {
                    if (textWithoutCommand.contains(talk.getUid())) {
                        Optional<Send> sendOptional = composeWithTalkId(chatId, talk.getUid());
                        if (sendOptional.isPresent()) {
                            return Optional.of(Collections.singletonList(sendOptional.get()));
                        }
                    }
                }
            }
        }

        SendMessage talkNotFoundMessage = new SendMessage();
        talkNotFoundMessage.setText("Agenda day not found " +  textWithoutCommand);
        talkNotFoundMessage.setChatId(chatId);
        return Optional.of(Collections.singletonList(talkNotFoundMessage));
    }

    @Nonnull
    public Optional<Send> composeWithTalkId(@Nonnull @NotBlank String chatId, @Nonnull @NotBlank String talkId) {
        Talk talk = this.agendaApi.fetchTalkById(talkId).blockingGet();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(htmlForTalk(talk));
        sendMessage.setDisableWebPagePreview(true);
        sendMessage.setParseMode(ParseMode.HTML.toString());
        sendMessage.setReplyMarkup(serializedInlineKeyboard(talk.getSpeakers().stream()
                .map(it -> new KeyboardButton(it, SpeakerCommandHandler.COMMAND_PREFFIX + SpeakerCommandHandler.COMMAND_SPEAKER + " " + it))
                .collect(Collectors.toList()), objectMapper, LOG));
        return Optional.of(sendMessage);
    }

    private String htmlForTalk(Talk talk) {
        HtmlBuilder builder = new HtmlBuilder();
        builder.bold(talk.getTitle()).newLine();
        if (talk.getStart() != null && talk.getEnd() != null) {
            builder.text(DayCommandHandler.TIME_FORMATTER.format(talk.getStart()) + " - " + DayCommandHandler.TIME_FORMATTER.format(talk.getEnd())).newLine();
        }
        if (talk.getAbout() != null) {
            for (String paragraph : talk.getAbout()) {
                builder = builder.text(cleanupUnsupportedHtmlTags(paragraph)).newLine();
            }
        }
        return builder.build();
    }

}
