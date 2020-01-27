package io.micronaut.bots.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

@Introspected
public class GetUserProfilePhotos {

    /**
     * Unique identifier of the target user.
     */
    @JsonProperty("user_id")
    @Nonnull
    @NotNull
    private Integer userId;

    /**
     * Sequential number of the first photo to be returned. By default, all photos are returned..
     */
    @Nullable
    private Integer offset;

    /**
     * Limits the number of photos to be retrieved. Values between 1—100 are accepted. Defaults to 100.
     */
    @Nullable
    private Integer limit;

    public GetUserProfilePhotos() {
    }

    @Nonnull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@Nonnull Integer userId) {
        this.userId = userId;
    }

    @Nullable
    public Integer getOffset() {
        return offset;
    }

    public void setOffset(@Nullable Integer offset) {
        this.offset = offset;
    }

    @Nullable
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(@Nullable Integer limit) {
        this.limit = limit;
    }
}
