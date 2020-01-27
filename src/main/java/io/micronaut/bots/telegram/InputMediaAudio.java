package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

/**
 * Represents an audio file to be treated as music to be sent.
 */
@Introspected
public class InputMediaAudio extends InputMediaDocument {
    private static final String TYPE_AUDIO = "audio";


    /**
     * Duration of the audio in seconds.
     */
    @Nullable
    private Integer duration;

    /**
     * Performer of the audio.
     */
    @Nullable
    private String performer;

    /**
     * Title of the audio
     */
    @Nullable
    private String title;

    public InputMediaAudio() {
        super(TYPE_AUDIO);
    }

    @Nullable
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    @Nullable
    public String getPerformer() {
        return performer;
    }

    public void setPerformer(@Nullable String performer) {
        this.performer = performer;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "InputMediaAudio{" +
                "duration=" + duration +
                ", performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                super.toString() +
                '}';
    }
}
