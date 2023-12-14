package com.rednet.chatservice.service;

import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;

import java.util.List;

public interface MessageService {
    List<Message> getLastMessagesPerConversation(List<ConversationKey> conversationKeys);
}
