package greachconf.agenda;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Introspected
public class Talk {

    @Nonnull
    private String uid;

    @Nonnull
    private String title;

    @Nonnull
    private List<String> about = new ArrayList<>();

    @Nonnull
    private List<String> tags = new ArrayList<>();

    @Nullable
    private String slides;

    @Nullable
    private String video;

    @Nullable
    private Set<String> speakers = new HashSet<>();

    @Nullable
    private LocalDateTime start;

    @Nullable
    private LocalDateTime end;

    @Nullable
    private String track;

    @Nullable
    private String location;

    @Nullable
    private String locationLink;

    public Talk() {

    }

    @Nonnull
    public String getUid() {
        return uid;
    }

    public void setUid(@Nonnull String uid) {
        this.uid = uid;
    }

    @Nullable
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(@Nullable LocalDateTime start) {
        this.start = start;
    }

    @Nullable
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(@Nullable LocalDateTime end) {
        this.end = end;
    }

    @Nullable
    public String getSlides() {
        return slides;
    }

    public void setSlides(@Nullable String slides) {
        this.slides = slides;
    }

    @Nullable
    public String getVideo() {
        return video;
    }

    public void setVideo(@Nullable String video) {
        this.video = video;
    }

    @Nullable
    public String getTrack() {
        return track;
    }

    public void setTrack(@Nullable String track) {
        this.track = track;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nonnull
    public List<String> getAbout() {
        return about;
    }

    public void setAbout(@Nonnull List<String> about) {
        this.about = about;
    }

    @Nullable
    public Set<String> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(@Nullable Set<String> speakers) {
        this.speakers = speakers;
    }

    @Nonnull
    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(@Nonnull List<String> tags) {
        this.tags = tags;
    }

    @Nullable
    public String getLocation() {
        return this.location;
    }

    public void setLocation(@Nullable String location) {
        this.location = location;
    }

    public void setLocationLink(@Nullable String locationLink) {
        this.locationLink = locationLink;
    }

    @Nullable
    public String getLocationLink() {
        return this.locationLink;
    }
}
