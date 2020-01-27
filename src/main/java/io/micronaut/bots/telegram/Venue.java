package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This object represents a venue.
 * @see <a href="https://core.telegram.org/bots/api#venue">Venue</a>
 */
@Introspected
public class Venue {

    /**
     * Venue location
     */
    @Nonnull
    @NotNull
    @Valid
    private Location location;

    /**
     * Name of the venue
     */
    @Nonnull
    @NotBlank
    private String title;
    /**
     * Address of the venue.
     */
    @Nonnull
    @NotBlank
    private String address;

    /**
     * Foursquare identifier of the venue.
     */
    @Nullable
    @JsonProperty("foursquare_id")
    private String foursquareId;

    /**
     * Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
     */
    @Nullable
    @JsonProperty("foursquare_type")
    private String foursquareType;

    public Venue() {
    }

    @Nonnull
    public Location getLocation() {
        return location;
    }

    public void setLocation(@Nonnull Location location) {
        this.location = location;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nonnull
    public String getAddress() {
        return address;
    }

    public void setAddress(@Nonnull String address) {
        this.address = address;
    }

    @Nullable
    public String getFoursquareId() {
        return foursquareId;
    }

    public void setFoursquareId(@Nullable String foursquareId) {
        this.foursquareId = foursquareId;
    }

    @Nullable
    public String getFoursquareType() {
        return foursquareType;
    }

    public void setFoursquareType(@Nullable String foursquareType) {
        this.foursquareType = foursquareType;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "location=" + (location != null ? location.toString() : "") +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", foursquareId='" + foursquareId + '\'' +
                ", foursquareType='" + foursquareType + '\'' +
                '}';
    }
}
