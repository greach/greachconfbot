package greachconf.bot;

import io.micronaut.bots.core.CommandHandler;

public class TextUtils {

    public static String textAfterCommand(String text, String command) {
        String commandPrefix = CommandHandler.COMMAND_PREFIX + command + " ";
        if (text.contains(commandPrefix)) {
            return text.substring(text.indexOf(commandPrefix) + commandPrefix.length());
        }
        return text;
    }
}
