package com.rednet.chatservice.service;

import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Optional<Message>> getLastMessagesPerConversation(List<ConversationKey> conversationKeys);
}
