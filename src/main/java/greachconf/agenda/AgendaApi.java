package greachconf.agenda;

import io.reactivex.Single;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import java.util.List;

public interface AgendaApi {
    Single<Agenda> fetchAgenda();

    Single<List<AgendaTalkSpeaker>> fetchSpeakers();

    Single<Speaker> fetchSpeakerById(@Nonnull @NotBlank String id);
}
