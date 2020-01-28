package greachconf.telegrambot;

import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaClient;
import greachconf.agenda.AgendaTalkSpeaker;
import greachconf.agenda.Speaker;
import io.micronaut.bots.telegram.HtmlBuilder;
import io.micronaut.bots.telegram.ParseMode;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.SendMessage;
import io.micronaut.bots.telegram.SendPhoto;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named(SpeakerCommandHandler.COMMAND_SPEAKER)
@Singleton
public class SpeakerCommandHandler extends AbstractCommandAndCallbackHandler {
    private static final Logger LOG = LoggerFactory.getLogger(SpeakerCommandHandler.class);

    public static final String COMMAND_SPEAKER = "speaker";
    private final AgendaApi agendaApi;

    public SpeakerCommandHandler(AgendaApi agendaApi) {
        this.agendaApi = agendaApi;

    }

    @Override
    public String getCommandName() {
        return COMMAND_SPEAKER;
    }

    @Override
    @Nonnull
    public Optional<List<Send>> compose(@Nonnull @NotBlank String chatId, @Nonnull @NotBlank String text) {
        String textWithoutCommand = cleanupCommand(text);
        try {
            List<AgendaTalkSpeaker> agendaTalkSpeakerList = this.agendaApi.fetchSpeakers().blockingGet();
            String selectedUid = null;
            for (AgendaTalkSpeaker agendaTalkSpeaker : agendaTalkSpeakerList) {
                if (textWithoutCommand.contains(agendaTalkSpeaker.getUid()) || textWithoutCommand.contains(agendaTalkSpeaker.getName())) {
                    selectedUid = agendaTalkSpeaker.getUid();
                    break;
                }
            }
            if (selectedUid != null) {
                return messagesForSpeakerUid(chatId, selectedUid);

            }
        } catch(HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching speakers", e);
            }
        }
        return Optional.empty();
    }

    Optional<List<Send>> messagesForSpeakerUid(String chatId, String speakerId) {
        List<Send> l = new ArrayList<>();
        try {
            Speaker speaker = this.agendaApi.fetchSpeakerById(speakerId).blockingGet();


            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(chatId);
            sendPhoto.setCaption(speaker.getName());
            sendPhoto.setPhoto(AgendaClient.GREACH_URL + speaker.getImage());
            l.add(sendPhoto);

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            sendMessage.setText(htmlForSpeaker(speaker));
            sendMessage.setDisableWebPagePreview(true);
            sendMessage.setParseMode(ParseMode.HTML.toString());
            l.add(sendMessage);
            return Optional.of(l);
        } catch(HttpClientResponseException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error fetching speaker by id", e);
            }
        }
        return Optional.empty();
    }

    private String htmlForSpeaker(Speaker speaker) {
        HtmlBuilder builder = new HtmlBuilder();
        if (speaker.getBio() != null) {
            for (String paragraph : speaker.getBio()) {
                builder = builder.text(cleanupUnsupportedHtmlTags(paragraph)).newLine();
            }
        }
        return builder.build();
    }
}
