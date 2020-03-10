package greachconf.bot.telegram;

import edu.umd.cs.findbugs.annotations.NonNull;
import greachconf.agenda.Talk;
import greachconf.bot.SpeakerCommandHandler;
import greachconf.bot.TalkMessageComposer;
import io.micronaut.bots.core.ChatBot;
import io.micronaut.bots.core.ChatBotMessageParser;
import io.micronaut.bots.core.ChatBotMessageReceive;
import io.micronaut.bots.core.ChatBotMessageSend;
import io.micronaut.bots.core.CommandHandler;
import io.micronaut.bots.core.ParseMode;
import io.micronaut.bots.telegram.HtmlBuilder;
import io.micronaut.bots.telegram.core.SendMessage;
import io.micronaut.bots.telegram.dispatcher.TelegramChatBotMessageParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class TelegramTalkMessageComposer implements TalkMessageComposer {
    private static final Logger LOG = LoggerFactory.getLogger(TelegramTalkMessageComposer.class);

    protected final ChatBotMessageParser messageParser;
    protected final KeyboardMessageComposer keyboardMessageComposer;

    public TelegramTalkMessageComposer(ChatBotMessageParser messageParser,
                                       KeyboardMessageComposer keyboardMessageComposer) {
        this.messageParser = messageParser;
        this.keyboardMessageComposer = keyboardMessageComposer;
    }

    @Override
    public Optional<ChatBotMessageSend> compose(@NonNull @Valid Talk talk,
                                                @NonNull ChatBot chatBot,
                                                @NonNull ChatBotMessageReceive messageReceive) {
        if (messageParser instanceof TelegramChatBotMessageParser) {
            Optional<Integer> chatIdOptional = ((TelegramChatBotMessageParser) messageParser).parseChatId(messageReceive);
            if (chatIdOptional.isPresent()) {
                Integer chatId = chatIdOptional.get();
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText(htmlForTalk(talk));
                sendMessage.setDisableWebPagePreview(true);
                sendMessage.setParseMode(ParseMode.HTML.toString());
                List<KeyboardMessageComposer.KeyboardButton> buttons = talk.getSpeakers().stream()
                        .map(it -> new KeyboardMessageComposer.KeyboardButton(it, chatBot.getAtUsername() + " " + CommandHandler.COMMAND_PREFIX + SpeakerCommandHandler.COMMAND_SPEAKER + " " + it))
                        .collect(Collectors.toList());
                keyboardMessageComposer.serializedInlineKeyboard(buttons).ifPresent(sendMessage::setReplyMarkup);

                if (LOG.isInfoEnabled()) {
                    LOG.info("replying message {}", sendMessage.toString());
                }
                return Optional.of(sendMessage);
            } else {
                if (LOG.isInfoEnabled()) {
                    LOG.info("could not parse chat id");
                }
            }
        } else {
            if (LOG.isInfoEnabled()) {
                LOG.info("messageParser not of TelegramChatBotMessageParser");
            }
        }
        return Optional.empty();
    }


    public String htmlForTalk(@NonNull @Valid Talk talk) {
        HtmlBuilder builder = new HtmlBuilder();
        builder.bold(talk.getTitle()).newLine();
        if (talk.getStart() != null && talk.getEnd() != null) {
            builder.text(TelegramDayComposer.TIME_FORMATTER.format(talk.getStart()) + " - " + TelegramDayComposer.TIME_FORMATTER.format(talk.getEnd())).newLine();
        }
        if (talk.getAbout() != null) {
            for (String paragraph : talk.getAbout()) {
                builder = builder.text(HtmlBuilder.cleanupUnsupportedHtmlTags(paragraph)).newLine();
            }
        }
        return builder.build();
    }
}
