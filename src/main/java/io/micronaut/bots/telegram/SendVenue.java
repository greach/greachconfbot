package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @see <a href="https://core.telegram.org/bots/api#sendvenue">SendVenue</a>
 */
@Introspected
public class SendVenue extends Send {
    /**
     * Latitude of the venue
     */
    @Nonnull
    @NotNull
    private Float latitude;

    /**
     * Longitude of the venue
     */
    @Nonnull
    @NotNull
    private Float longitude;

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

    public SendVenue() {
        super("sendVenue");
    }

    @Nonnull
    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(@Nonnull Float latitude) {
        this.latitude = latitude;
    }

    @Nonnull
    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(@Nonnull Float longitude) {
        this.longitude = longitude;
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
}
