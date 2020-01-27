package greachconf.agenda;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

@Introspected
public class TalkRow implements Comparable<TalkRow> {
    @Nonnull
    private String uid;

    @Nonnull
    private String title;

    @Nullable
    private Set<String> speakers = new HashSet<>();

    @Nullable
    private String location;

    @Nullable
    private String locationLink;

    public TalkRow() {

    }

    public TalkRow(String uid,
                   String title,
                   Set<String> speakers,
                   String location,
                   String locationLink) {
        this.uid = uid;
        this.title = title;
        this.speakers = speakers;
        this.location = location;
        this.locationLink = locationLink;
    }

    @Nonnull
    public String getUid() {
        return uid;
    }

    public void setUid(@Nonnull String uid) {
        this.uid = uid;
    }

    @Nonnull
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nonnull String title) {
        this.title = title;
    }

    @Nullable
    public Set<String> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(@Nullable Set<String> speakers) {
        this.speakers = speakers;
    }

    @Override
    public int compareTo(TalkRow o) {
        return this.getTitle().compareTo(o.getTitle());
    }

    @Nullable
    public String getLocation() {
        return location;
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
