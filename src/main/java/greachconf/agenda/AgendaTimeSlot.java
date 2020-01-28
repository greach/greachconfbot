package greachconf.agenda;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

@Introspected
public class AgendaTimeSlot implements Comparable<AgendaTimeSlot> {

    @Nonnull
    private TimeSlot timeSlot;

    @Nullable
    private Map<String, AgendaTalk> trackTalks;

    @Nonnull
    private List<AgendaItem> items;

    public AgendaTimeSlot() {}

    public AgendaTimeSlot(TimeSlot timeSlot, Map<String, AgendaTalk> trackTalks, List<AgendaItem> items) {
        this.timeSlot = timeSlot;
        this.trackTalks = trackTalks;
        this.items = items;
    }

    @Nonnull
    public List<AgendaItem> getItems() {
        return items;
    }

    public void setItems(@Nonnull List<AgendaItem> items) {
        this.items = items;
    }

    @Nonnull
    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(@Nonnull TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Nullable
    public Map<String, AgendaTalk> getTrackTalks() {
        return trackTalks;
    }

    public void setTrackTalks(@Nullable Map<String, AgendaTalk> trackTalks) {
        this.trackTalks = trackTalks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgendaTimeSlot that = (AgendaTimeSlot) o;

        if (!timeSlot.equals(that.timeSlot)) return false;
        if (!trackTalks.equals(that.trackTalks)) return false;
        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        int result = timeSlot.hashCode();
        result = 31 * result + trackTalks.hashCode();
        result = 31 * result + items.hashCode();
        return result;
    }

    @Override
    public int compareTo(AgendaTimeSlot o) {
        return getTimeSlot().compareTo(o.getTimeSlot());
    }
}
