package io.micronaut.bots.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.inject.qualifiers.Qualifiers;
import io.micronaut.scheduling.TaskExecutors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@Singleton
public class DefaultUpdateHandler implements UpdateHandler {

    private final ObjectMapper objectMapper;
    private final ApplicationContext applicationContext;
    private final ExecutorService executorService;
    public static final Comparator<String> COMMANDS_COMPARATORS = (o1, o2) -> {
        if (o1.length() == o2.length()) {
            return o1.compareTo(o2);
        }
        return o1.length() > o2.length() ? -1 : 1;
    };

    public DefaultUpdateHandler(ObjectMapper objectMapper,
                                ApplicationContext applicationContext,
                                @Named(TaskExecutors.IO) ExecutorService executorService) {
        this.objectMapper = objectMapper;
        this.applicationContext = applicationContext;
        this.executorService = executorService;
    }

    @Nonnull
    @Override
    public Optional<Send> handleUpdate(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                       @Nonnull @NotNull @Valid Update update) {

        List<String> commands = configuration.getCommands().stream().sorted(COMMANDS_COMPARATORS).collect(Collectors.toList());

        if (applicationContext.containsBean(TelegramBot.class, Qualifiers.byName(configuration.getName()))) {
            TelegramBot telegramBot = applicationContext.getBean(TelegramBot.class, Qualifiers.byName(configuration.getName()));

            SendMessage echo = echoUpdateMessage(objectMapper, update);
            telegramBot.sendMessage(echo).blockingGet();
            if (update.getCallbackQuery() !=null) {
                String text = update.getCallbackQuery().getData();
                if (text != null) {
                    for (String command : commands) {
                        if (text.contains(CommandHandler.COMMAND_PREFFIX + command)) {
                            if (applicationContext.containsBean(CallbackQueryHandler.class, Qualifiers.byName(command))) {
                                CallbackQueryHandler commandHandler = applicationContext.getBean(CallbackQueryHandler.class, Qualifiers.byName(command));
                                Optional<CallbackQueryResponse> callbackQueryResponseOptional = commandHandler.handle(configuration, update.getCallbackQuery());
                                if (callbackQueryResponseOptional.isPresent()) {
                                    CallbackQueryResponse callbackQueryResponse = callbackQueryResponseOptional.get();

//                                    try {
//                                        echo.setText(objectMapper.writeValueAsString(callbackQueryResponse));
//                                        telegramBot.sendMessage(echo).blockingGet();
//                                    } catch (JsonProcessingException e) {
//                                        e.printStackTrace();
//                                    }

                                    telegramBot.answerCallbackQuery(callbackQueryResponse.getAnswerCallbackQuery());
                                    if (callbackQueryResponse.getMessages() != null) {
                                        sendMessages(telegramBot, callbackQueryResponse.getMessages());
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            } else if (update.getMessage() != null) {
                handleMessage(configuration, update, telegramBot);
            }
        }

        return Optional.empty();
    }

    private void handleMessage(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                               @Nonnull @NotNull @Valid Update update,
                               TelegramBot telegramBot) {
        List<String> commands = configuration.getCommands()
                .stream()
                .sorted(COMMANDS_COMPARATORS)
                .collect(Collectors.toList());

        String text = update.getMessage().getText();
        if (text != null) {
            for (String command : commands) {
                if (text.contains(CommandHandler.COMMAND_PREFFIX + command)) {
                    if (applicationContext.containsBean(CommandHandler.class, Qualifiers.byName(command))) {
                        CommandHandler commandHandler = applicationContext.getBean(CommandHandler.class, Qualifiers.byName(command));
                        Optional<List<Send>> l = commandHandler.compose(configuration, update);
                        l.ifPresent(messages -> sendMessages(telegramBot, messages));
                    }
                    break;
                }
            }
        }
    }

    @Nullable
    public static SendMessage echoUpdateMessage(ObjectMapper objectMapper, Update update) {
        SendMessage sendMessage = new SendMessage();
        String chatId = "718074279";
        sendMessage.setChatId(chatId);
        try {
            sendMessage.setText(objectMapper.writeValueAsString(update));
            return sendMessage;
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Nullable
    private SendMessage errorMessage(Send input, HttpClientResponseException e) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(input.getChatId());
        try {
            sendMessage.setText("error " + e.getStatus().getCode() + e.getMessage() + " sending message " + objectMapper.writeValueAsString(input));
            return sendMessage;
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void sendMessages(TelegramBot telegramBot, List<Send> messages) {
        for (Send send : messages) {
            if (send instanceof SendMessage) {
                SendMessage sendMessage = (SendMessage) send;
                try {
                    telegramBot.sendMessage(sendMessage).blockingGet();
//                                                    .subscribeOn(Schedulers.from(executorService))
//                                                    .subscribe(t -> {
//                                            });
                } catch (HttpClientResponseException e) {
                    SendMessage error = errorMessage(sendMessage, e);
                    telegramBot.sendMessage(error).blockingGet();
                }

            } else if (send instanceof SendPhoto) {
                SendPhoto sendPhoto = (SendPhoto) send;
                try {
                    telegramBot.sendPhoto(sendPhoto).blockingGet();
//                                                    .subscribeOn(Schedulers.from(executorService))
//                                                    .subscribe(t -> {
//                                                    });
                } catch (HttpClientResponseException e) {
                    SendMessage error = errorMessage(sendPhoto, e);
                    telegramBot.sendMessage(error).blockingGet();
                }
            }
        }
    }
}
