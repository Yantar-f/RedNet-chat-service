package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.service.ConversationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {
    @Override
    public List<Conversation> getConversationsByUserID(String userID) {
        return null;
    }

    @Override
    public Conversation createConversation(String creatorID, List<String> memberIDs, String title) {
        return null;
    }
}
