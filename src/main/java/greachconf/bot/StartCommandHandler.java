package greachconf.bot;

import io.micronaut.bots.core.FileCommandHandler;
import io.micronaut.bots.core.MessageComposer;
import io.micronaut.bots.core.ParseMode;

import javax.inject.Named;
import javax.inject.Singleton;

@Named(StartCommandHandler.COMMAND_START)
@Singleton
public class StartCommandHandler extends FileCommandHandler {

    public static final String COMMAND_START = "start";

    public StartCommandHandler(MessageComposer messageComposer) {
        super(ParseMode.MARKDOWN, "classpath:help.md", messageComposer);
    }
}
