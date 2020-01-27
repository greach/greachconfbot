package greachconf.telegrambot;

import greachconf.agenda.AgendaApi;
import greachconf.agenda.AgendaClient;
import greachconf.agenda.AgendaTalkSpeaker;
import greachconf.agenda.Speaker;
import io.micronaut.bots.telegram.HtmlBuilder;
import io.micronaut.bots.telegram.ParseMode;
import io.micronaut.bots.telegram.CommandHandler;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.SendMessage;
import io.micronaut.bots.telegram.SendPhoto;
import io.micronaut.bots.telegram.TelegramBotConfiguration;
import io.micronaut.bots.telegram.Update;

import javax.annotation.Nonnull;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named(SpeakerCommandHandler.COMMAND_SPEAKER)
@Singleton
public class SpeakerCommandHandler implements CommandHandler {

    public static final String COMMAND_SPEAKER = "speaker";
    private final AgendaApi agendaApi;

    public SpeakerCommandHandler(AgendaApi agendaApi) {
        this.agendaApi = agendaApi;

    }

    @Override
    public String getCommandName() {
        return COMMAND_SPEAKER;
    }

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        String text = update.getMessage().getText();
        if (text == null) {
            return Optional.empty();
        }
        Integer chatId = update.getMessage().getChat().getId();
        return compose(String.valueOf(chatId), text);
    }

    @Nonnull
    public Optional<List<Send>> compose(@Nonnull @NotBlank String chatId, @Nonnull @NotBlank String text) {
        String textWithoutCommand = cleanupCommand(text);
        List<AgendaTalkSpeaker> agendaTalkSpeakerList = this.agendaApi.fetchSpeakers().blockingGet();
        String selectedUid = null;
        for (AgendaTalkSpeaker agendaTalkSpeaker : agendaTalkSpeakerList) {
            if (textWithoutCommand.contains(agendaTalkSpeaker.getUid()) || textWithoutCommand.contains(agendaTalkSpeaker.getName())) {
                selectedUid = agendaTalkSpeaker.getUid();
                break;
            }
        }
        if (selectedUid != null) {
            return Optional.of(messagesForSpeakerUid(chatId, selectedUid));

        }
        return Optional.empty();
    }

    List<Send> messagesForSpeakerUid(String chatId, String speakerId) {
        List<Send> l = new ArrayList<>();
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
       return l;
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
