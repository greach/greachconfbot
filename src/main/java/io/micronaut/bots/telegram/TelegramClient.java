package io.micronaut.bots.telegram;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Client("https://api.telegram.org")
public interface TelegramClient extends TelegramApi {

    @Override
    @Post("/bot{token}/getMe")
    Single<User> getMe(@PathVariable @Nonnull @NotBlank String token);

    @Override
    @Post("/bot{token}/sendMessage")
    Single<MessageSent> sendMessage(@PathVariable @Nonnull @NotBlank String token,
                                    @Body @Nonnull @NotNull @Valid SendMessage sendMessage);

    @Override
    @Post("/bot{token}/forwardMessage")
    Single<MessageSent> forwardMessage(@PathVariable @Nonnull @NotBlank String token,
                                       @Body @Nonnull @NotNull @Valid ForwardMessage forwardMessage);

    @Override
    @Post("/bot{token}/sendPhoto")
    Single<MessageSent> sendPhoto(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendPhoto sendPhoto);

    @Override
    @Post("/bot{token}/sendAudio")
    Single<MessageSent> sendAudio(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendAudio sendAudio);

    @Override
    @Post("/bot{token}/sendDocument")
    Single<MessageSent> sendDocument(@PathVariable @Nonnull @NotBlank String token,
                                     @Body @Nonnull @NotNull @Valid SendDocument sendDocument);

    @Override
    @Post("/bot{token}/sendVideo")
    Single<MessageSent> sendVideo(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendVideo sendVideo);

    @Override
    @Post("/bot{token}/sendVoice")
    Single<MessageSent> sendVoice(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendVoice sendVoice);

    @Override
    @Post("/bot{token}/sendVenue")
    Single<MessageSent> sendVenue(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendVenue sendMessage);

    @Override
    @Post("/bot{token}/sendContact")
    Single<MessageSent> sendContact(@PathVariable @Nonnull @NotBlank String token,
                                    @Body @Nonnull @NotNull @Valid SendContact sendContact);


    @Override
    @Post("/bot{token}/sendPoll")
    Single<MessageSent> sendPoll(@PathVariable @Nonnull @NotBlank String token,
                                 @Body @Nonnull @NotNull @Valid SendPoll sendPoll);

    @Override
    @Get("/bot{token}/getUserProfilePhotos")
    Single<UserProfilePhotos> getUserProfilePhotos(@PathVariable @Nonnull @NotBlank String token,
                                                   @Nonnull @NotNull @Valid GetUserProfilePhotos getUserProfilePhotos);
}
