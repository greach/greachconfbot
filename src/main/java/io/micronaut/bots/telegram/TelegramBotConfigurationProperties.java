package io.micronaut.bots.telegram;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@EachProperty("telegram.bots")
public class TelegramBotConfigurationProperties implements TelegramBotConfiguration {

    private final static boolean DEFAULT_ENABLED = true;

    private boolean enabled = DEFAULT_ENABLED;

    @Nonnull
    private final String name;

    @NotBlank
    @Nonnull
    private String token;

    @NotNull
    @Nonnull
    private List<String> commands = new ArrayList<>();

    public TelegramBotConfigurationProperties(@Parameter String name) {
        this.name = name;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    @Nonnull
    public String getName() {
        return name;
    }

    @Override
    @Nonnull
    public String getToken() {
        return token;
    }

    public void setToken(@Nonnull String token) {
        this.token = token;
    }

    @Override
    @Nonnull
    public List<String> getCommands() {
        return commands.stream().sorted((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return 0;
            }
            return o2.length() > o1.length() ? 1 : -1;
        }).collect(Collectors.toList());
    }

    public void setCommands(@Nonnull List<String> commands) {
        this.commands = commands;
    }
}
