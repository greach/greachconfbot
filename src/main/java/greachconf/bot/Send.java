/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Sergio del Amo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package greachconf.bot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.bots.core.ChatBotMessageSend;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Send implements ChatBotMessageSend {

    @NonNull
    protected final String method;

    /**
     * Unique identifier for the target chat or username of the target channel (in the format @channelusername)
     * Integer or String
     */
    @JsonProperty("chat_id")
    @NotNull
    @NonNull
    private Object chatId;

    /**
     * Sends the message silently. Users will receive a notification with no sound.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("disable_notification")
    private Boolean disableNotification;

    /**
     * If the message is a reply, ID of the original message.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reply_to_message_id")
    private String replyToMessageId;


    /**
     * additional interface options. A JSON-serialized object for an inline keyboard, custom reply keyboard, instructions to remove reply keyboard or to force a reply from the user.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("reply_markup")
    private String replyMarkup;

    public Send(String method) {
        this.method = method;
    }

    @NonNull
    public String getMethod() {
        return method;
    }

    @NonNull
    public Object getChatId() {
        return chatId;
    }

    public void setChatId(@NonNull Object chatId) {
        this.chatId = chatId;
    }

    @Nullable
    public Boolean getDisableNotification() {
        return disableNotification;
    }

    public void setDisableNotification(@Nullable Boolean disableNotification) {
        this.disableNotification = disableNotification;
    }

    @Nullable
    public String getReplyToMessageId() {
        return replyToMessageId;
    }

    public void setReplyToMessageId(@Nullable String replyToMessageId) {
        this.replyToMessageId = replyToMessageId;
    }

    @Nullable
    public String getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(@Nullable String replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
