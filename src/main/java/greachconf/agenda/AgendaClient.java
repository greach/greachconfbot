package greachconf.agenda;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Client(AgendaClient.GREACH_URL)
public interface AgendaClient extends AgendaApi {
    String GREACH_URL = "https://greachconf.com";

    @Override
    @Get("/api/agenda.json")
    Single<Agenda> fetchAgenda();

    @Override
    @Get("/api/speakers.json")
    Single<List<AgendaTalkSpeaker>> fetchSpeakers();

    @Override
    @Get("/api/speaker/{id}.json")
    Single<Speaker> fetchSpeakerById(@Nonnull @NotBlank String id);

}
