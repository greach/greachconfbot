package greachconf.bot.telegram;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.bots.telegram.core.InlineKeyboardButton;
import io.micronaut.bots.telegram.core.InlineKeyboardMarkup;
import io.micronaut.context.annotation.Requires;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Requires(classes = InlineKeyboardMarkup.class)
@Singleton
public class KeyboardMessageComposer {
    private static final Logger LOG = LoggerFactory.getLogger(KeyboardMessageComposer.class);

    protected final ObjectMapper objectMapper;

    public KeyboardMessageComposer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Optional<String> serializedInlineKeyboard(List<KeyboardMessageComposer.KeyboardButton> buttons) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for (KeyboardMessageComposer.KeyboardButton b : buttons) {
            InlineKeyboardButton btn = new InlineKeyboardButton();
            btn.setCallbackData(b.getData());
            btn.setText(b.getTitle());
            keyboard.add(Collections.singletonList(btn));
        }
        inlineKeyboardMarkup.setInlineKeyboard(keyboard);
        return serializeInlineKeyboardMarkup(inlineKeyboardMarkup);
    }


    public Optional<String> serializeInlineKeyboardMarkup(@NonNull InlineKeyboardMarkup inlineKeyboardMarkup) {
        try {
            return Optional.of(objectMapper.writeValueAsString(inlineKeyboardMarkup));
        } catch (JsonProcessingException e) {
            if (LOG.isErrorEnabled()) {
                LOG.error("error generating serialized JSON of inlineKeyboard", e);
            }
        }
        return Optional.empty();
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
