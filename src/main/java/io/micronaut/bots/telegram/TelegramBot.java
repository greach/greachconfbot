package io.micronaut.bots.telegram;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TelegramBot {

    @NotBlank
    @Nonnull
    private String token;

    private TelegramApi telegramApi;

    public TelegramBot(String token, TelegramApi telegramApi) {
        this.token = token;
        this.telegramApi = telegramApi;
    }

    public Single<User> getMe() {
        return this.telegramApi.getMe(token);
    }

    public Single<MessageSent> sendMessage(@Nonnull @NotNull @Valid SendMessage sendMessage) {

        return this.telegramApi.sendMessage(token, sendMessage);
    }

    public Single<MessageSent> forwardMessage(@Nonnull @NotNull @Valid ForwardMessage forwardMessage) {
        return this.telegramApi.forwardMessage(token, forwardMessage);
    }

    public Single<MessageSent> sendPhoto(@Nonnull @NotNull @Valid SendPhoto sendPhoto){
        return this.telegramApi.sendPhoto(token, sendPhoto);
    }

    public Single<MessageSent> sendAudio(@Nonnull @NotNull @Valid SendAudio sendAudio) {
        return this.telegramApi.sendAudio(token, sendAudio);
    }

    public Single<MessageSent> sendDocument(@Nonnull @NotNull @Valid SendDocument sendDocument) {
        return this.telegramApi.sendDocument(token, sendDocument);
    }

    public Single<MessageSent> sendVideo(@Nonnull @NotNull @Valid SendVideo sendVideo) {
        return this.telegramApi.sendVideo(token, sendVideo);
    }

    public Single<MessageSent> sendAnimation(@Nonnull @NotNull @Valid SendVideo sendVideo) {
        return this.telegramApi.sendVideo(token, sendVideo);
    }

    public Single<MessageSent> sendVoice(@Nonnull @NotNull @Valid SendVoice sendVoice) {
        return this.telegramApi.sendVoice(token, sendVoice);
    }

    public Single<MessageSent> sendVenue(@Nonnull @NotNull @Valid SendVenue sendMessage) {
        return this.telegramApi.sendVenue(token, sendMessage);
    }

    public Single<MessageSent> sendContact(@Nonnull @NotNull @Valid SendContact sendContact) {
        return this.telegramApi.sendContact(token, sendContact);
    }

    public Single<MessageSent> sendPoll(@Body @Nonnull @NotNull @Valid SendPoll sendPoll) {
        return this.telegramApi.sendPoll(token, sendPoll);
    }

    public Single<UserProfilePhotos> getUserProfilePhotos(@Nonnull @NotNull @Valid GetUserProfilePhotos getUserProfilePhotos) {
        return this.telegramApi.getUserProfilePhotos(token, getUserProfilePhotos);
    }
}
