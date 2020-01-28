package greachconf.agenda;

import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Completable;
import io.reactivex.Single;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import java.util.List;

public interface AgendaApi {
    Single<Agenda> fetchAgenda();

    Single<List<AgendaTalkSpeaker>> fetchSpeakers();

    Single<Speaker> fetchSpeakerById(@PathVariable  @Nonnull @NotBlank String id);

    Single<Talk> fetchTalkById(@PathVariable @Nonnull @NotBlank String id);
}
