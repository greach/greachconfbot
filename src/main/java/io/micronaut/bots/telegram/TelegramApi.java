package io.micronaut.bots.telegram;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Single;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface TelegramApi {

    Single<User> getMe(@PathVariable @Nonnull @NotBlank String token);

    Single<MessageSent> forwardMessage(@PathVariable @Nonnull @NotBlank String token,
                                       @Body @Nonnull @NotNull @Valid ForwardMessage forwardMessage);

    Single<MessageSent> sendMessage(@PathVariable @Nonnull @NotBlank String token,
                                @Body @Nonnull @NotNull @Valid SendMessage sendMessage);

    Single<MessageSent> sendPhoto(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendPhoto sendPhoto);

    Single<MessageSent> sendAudio(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendAudio sendAudio);

    Single<MessageSent> sendDocument(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendDocument sendDocument);

    Single<MessageSent> sendVideo(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendVideo sendVideo);

    Single<MessageSent> sendVoice(@PathVariable @Nonnull @NotBlank String token,
                                  @Body @Nonnull @NotNull @Valid SendVoice sendVoice);

    Single<MessageSent> sendVenue(@PathVariable @Nonnull @NotBlank String token,
                              @Body @Nonnull @NotNull @Valid SendVenue sendMessage);

    /**
     * Use this method to send phone contacts.
     * @param token Telegram Bot Token
     * @param sendContact Contact
     * @return The sent Message
     */
    Single<MessageSent> sendContact(@PathVariable @Nonnull @NotBlank String token,
                                    @Body @Nonnull @NotNull @Valid SendContact sendContact);

    /**
     * Use this method to send a native poll.
     * @param token Telegram Bot Token
     * @param sendPoll poll
     * @return The sent Message
     */
    Single<MessageSent> sendPoll(@PathVariable @Nonnull @NotBlank String token,
                                 @Body @Nonnull @NotNull @Valid SendPoll sendPoll);

    /**
     * Use this method to send a native poll.
     * @param token Telegram Bot Token
     * @param getUserProfilePhotos Request User Profile Photos
     * @return The sent Message
     */
    Single<UserProfilePhotos> getUserProfilePhotos(@PathVariable @Nonnull @NotBlank String token,
                                                   @Nonnull @NotNull @Valid GetUserProfilePhotos getUserProfilePhotos);
}
