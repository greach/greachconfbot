package greachconf.bot;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "GreachconfBot",
                version = "0.1",
                description = "GreachconfBot API",
                contact = @Contact(url = "https://greachconf.com", name = "Sergio del Amo", email = "delamos@greachconf.com")
        )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}