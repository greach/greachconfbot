package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nullable;

/**
 * Represents an animation file (GIF or H.264/MPEG-4 AVC video without sound) to be sent.
 */
@Introspected
public class InputMediaAnimation extends InputMediaDocument {
    private static final String TYPE_ANIMATION = "animation";

    /**
     * Animation width.
     */
    @Nullable
    private Integer width;

    /**
     * Animation height.
     */
    @Nullable
    private Integer height;

    /**
     * Animation duration.
     */
    @Nullable
    private Integer duration;

    public InputMediaAnimation() {
        super(TYPE_ANIMATION);
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

    @Override
    public String toString() {
        return "InputMediaAnimation{" +
                "width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                super.toString() +
                '}';
    }
}
