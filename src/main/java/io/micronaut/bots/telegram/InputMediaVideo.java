package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

/**
 * Represents a video to be sent.
 */
@Introspected
public class InputMediaVideo extends InputMediaDocument {
    private static final String TYPE_VIDEO = "video";

    /**
     * Video width.
     */
    @Nullable
    private Integer width;

    /**
     * Video height.
     */
    @Nullable
    private Integer height;

    /**
     * Video duration.
     */
    @Nullable
    private Integer duration;

    /**
     *  Pass True, if the uploaded video is suitable for streaming.
     */
    @Nullable
    @JsonProperty("supports_streaming")
    private Boolean supportsStreaming;

    public InputMediaVideo() {
        super(TYPE_VIDEO);
    }

    @Nullable
    public Integer getWidth() {
        return width;
    }

    public void setWidth(@Nullable Integer width) {
        this.width = width;
    }

    @Nullable
    public Integer getHeight() {
        return height;
    }

    public void setHeight(@Nullable Integer height) {
        this.height = height;
    }

    @Nullable
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@Nullable Integer duration) {
        this.duration = duration;
    }

    @Nullable
    public Boolean getSupportsStreaming() {
        return supportsStreaming;
    }

    public void setSupportsStreaming(@Nullable Boolean supportsStreaming) {
        this.supportsStreaming = supportsStreaming;
    }

    @Override
    public String toString() {
        return "InputMediaVideo{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", supportsStreaming=" + supportsStreaming +
                '}';
    }
}
