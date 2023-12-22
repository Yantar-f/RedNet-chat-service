package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public List<Optional<Message>> getLastMessagesPerConversation(List<ConversationKey> conversationKeys) {
        return null;
    }
}
