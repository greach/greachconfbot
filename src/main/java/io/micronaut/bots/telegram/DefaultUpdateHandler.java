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
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;

@Singleton
public class DefaultUpdateHandler implements UpdateHandler {

    private final ObjectMapper objectMapper;
    private final ApplicationContext applicationContext;
    private final ExecutorService executorService;


    public DefaultUpdateHandler(ObjectMapper objectMapper,
                                ApplicationContext applicationContext,
                                @Named(TaskExecutors.IO) ExecutorService executorService) {
        this.objectMapper = objectMapper;
        this.applicationContext = applicationContext;
        this.executorService = executorService;
    }

    @Nonnull
    @Override
    public Optional<Send> handUpdate(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                     @Nonnull @NotNull @Valid Update update) {

        if (applicationContext.containsBean(TelegramBot.class, Qualifiers.byName(configuration.getName()))) {
            TelegramBot telegramBot = applicationContext.getBean(TelegramBot.class, Qualifiers.byName(configuration.getName()));

//            SendMessage echo = echoUpdateMessage(update);
//            telegramBot.sendMessage(echo).blockingGet();

                if (update.getCallbackQuery() !=null) {
                if (update.getCallbackQuery().getMessage() != null) {
                    String text = update.getCallbackQuery().getMessage().getText();
                    if (text != null) {
                        for (String command : configuration.getCommands()) {
                            if (text.contains(CommandHandler.COMMAND_PREFFIX + command)) {
                                if (applicationContext.containsBean(CallbackQueryHandler.class, Qualifiers.byName(command))) {
                                    CallbackQueryHandler commandHandler = applicationContext.getBean(CallbackQueryHandler.class, Qualifiers.byName(command));
                                    Optional<List<Send>> l = commandHandler.handle(configuration, update.getCallbackQuery());
                                    sendMessages(telegramBot, l);
                                }
                            }
                            break;
                        }

                    }
                }
            } else if (update.getMessage() != null) {
                String text = update.getMessage().getText();
                if (text != null) {
                    for (String command : configuration.getCommands()) {
                        if (text.contains(CommandHandler.COMMAND_PREFFIX + command)) {
                            if (applicationContext.containsBean(CommandHandler.class, Qualifiers.byName(command))) {
                                CommandHandler commandHandler = applicationContext.getBean(CommandHandler.class, Qualifiers.byName(command));
                                Optional<List<Send>> l = commandHandler.compose(configuration, update);
                                sendMessages(telegramBot, l);
                            }
                            break;
                        }
                    }
                }
            }
        }

        return Optional.empty();
    }

    @Nullable
    private SendMessage echoUpdateMessage(Update update) {
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

    private void sendMessages(TelegramBot telegramBot, Optional<List<Send>> messages) {
        if (messages.isPresent()) {
            for (Send send : messages.get()) {
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
}
