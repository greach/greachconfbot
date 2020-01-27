package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 * @see <a href="https://core.telegram.org/bots/api#game">Game</a>
 */
@Introspected
public class Game {

    /**
     * Title of the game
     */
    @Nonnull
    @NotBlank
    private String title;

    /**
     * Description of the game
     */
    @Nonnull
    @NotBlank
    private String description;

    /**
     * Photo that will be displayed in the game message in chats.
     */
    @Nonnull
    @NotNull
    private List<PhotoSize> photo;

    /**
     * Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls setGameScore, or manually edited using editMessageText. 0-4096 characters.
     */
    @Nullable
    private String text;

    /**
     * Special entities that appear in text, such as usernames, URLs, bot commands, etc.
     */
    @Nullable
    @JsonProperty("text_entities")
    private List<MessageEntity> textEntities;

    /**
     * Animation that will be displayed in the game message in chats. Upload via BotFather
     */
    @Nullable
    Animation animation;

    public Game() {
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nonnull
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nonnull String description) {
        this.description = description;
    }

    @Nonnull
    public List<PhotoSize> getPhoto() {
        return photo;
    }

    public void setPhoto(@Nonnull List<PhotoSize> photo) {
        this.photo = photo;
    }

    @Nullable
    public String getText() {
        return text;
    }

    public void setText(@Nullable String text) {
        this.text = text;
    }

    @Nullable
    public List<MessageEntity> getTextEntities() {
        return textEntities;
    }

    public void setTextEntities(@Nullable List<MessageEntity> textEntities) {
        this.textEntities = textEntities;
    }

    @Nullable
    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(@Nullable Animation animation) {
        this.animation = animation;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + (photo != null ? String.join(",", photo.stream().map(PhotoSize::toString).collect(Collectors.toList())) : "") +
                ", text='" + text +
                ", textEntities=" + (textEntities != null ?  String.join(",",textEntities.stream().map(MessageEntity::toString).collect(Collectors.toList())) : "") +
                ", animation=" + animation +
                '}';
    }
}
