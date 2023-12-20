package com.rednet.chatservice.service;


import com.rednet.chatservice.entity.Conversation;

import java.util.List;

public interface ConversationService {
    List<Conversation>  getConversationsByUserID    (String userID);
    Conversation        createConversation          (String creatorID, List<String> memberIDs, String  title);
}
