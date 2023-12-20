package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public List<Message> getLastMessagesPerConversation(List<ConversationKey> conversationKeys) {
        return null;
    }
}
