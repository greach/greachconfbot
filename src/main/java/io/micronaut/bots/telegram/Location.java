package io.micronaut.bots.telegram;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;

/**
 * This object represents a point on the map.
 * @see <a href="https://core.telegram.org/bots/api#location">Location</a>
 */
@Introspected
public class Location {

    /**
     * Longitude as defined by sender.
     */
    @Nonnull
    @NotNull
    private Float longitude;

    /**
     * Latitude as defined by sender
     */
    @Nonnull
    @NotNull
    private Float latitude;

    public Location() {
    }

    @Nonnull
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(@Nonnull Float longitude) {
        this.longitude = longitude;
    }

    @Nonnull
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(@Nonnull Float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
