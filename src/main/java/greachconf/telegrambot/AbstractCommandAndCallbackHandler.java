package greachconf.telegrambot;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.bots.telegram.AnswerCallbackQuery;
import io.micronaut.bots.telegram.CallbackQuery;
import io.micronaut.bots.telegram.CallbackQueryHandler;
import io.micronaut.bots.telegram.CallbackQueryResponse;
import io.micronaut.bots.telegram.CommandHandler;
import io.micronaut.bots.telegram.InlineKeyboardButton;
import io.micronaut.bots.telegram.InlineKeyboardMarkup;
import io.micronaut.bots.telegram.Send;
import io.micronaut.bots.telegram.TelegramBotConfiguration;
import io.micronaut.bots.telegram.Update;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCommandAndCallbackHandler implements CommandHandler, CallbackQueryHandler {

    public abstract Optional<List<Send>> compose(@Nonnull @NotBlank String chatId, @Nonnull @NotBlank String text);

    @Override
    public Optional<CallbackQueryResponse> handle(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                                  @Nonnull @NotNull @Valid CallbackQuery callbackQuery) {
        CallbackQueryResponse response = new CallbackQueryResponse();
        AnswerCallbackQuery answerCallbackQuery = new AnswerCallbackQuery();
        answerCallbackQuery.setCallbackQueryId(callbackQuery.getId());
        response.setAnswerCallbackQuery(answerCallbackQuery);
        Optional<List<Send>> messages = compose(String.valueOf(callbackQuery.getFrom().getId()), callbackQuery.getData());
        messages.ifPresent(response::setMessages);
        return Optional.of(response);
    }

    public String serializedInlineKeyboard(List<KeyboardButton> buttons,
                                           ObjectMapper objectMapper,
                                           Logger logger) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for (KeyboardButton b : buttons) {
            InlineKeyboardButton btn = new InlineKeyboardButton();
            btn.setCallbackData(b.getData());
            btn.setText(b.getTitle());
            keyboard.add(Collections.singletonList(btn));
        }
        inlineKeyboardMarkup.setInlineKeyboard(keyboard);
        return serializeInlineKeyboardMarkup(inlineKeyboardMarkup, objectMapper, logger);
    }

    @Nonnull
    @Override
    public Optional<List<Send>> compose(@Nonnull @NotNull @Valid TelegramBotConfiguration configuration,
                                        @Nonnull @NotNull @Valid Update update) {
        if (update.getMessage() == null) {
            return Optional.empty();
        }
        String text = update.getMessage().getText();
        if (text == null) {
            return Optional.empty();
        }
        Integer chatId = update.getMessage().getChat().getId();
        return compose(String.valueOf(chatId), text);
    }

    static class KeyboardButton {
        private String data;
        private String title;

        public KeyboardButton(String title, String data) {
            this.title = title;
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public String getTitle() {
            return title;
        }
    }
}
