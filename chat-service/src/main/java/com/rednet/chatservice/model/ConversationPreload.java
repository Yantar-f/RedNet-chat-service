package com.rednet.chatservice.model;

import com.rednet.chatservice.entity.Conversation;

public record ConversationPreload(String conversationID, String creatorID, String title, MessageModel lastMessage) {
    public ConversationPreload(Conversation conversation, MessageModel lastMessage) {
        this(conversation.conversationID(), conversation.creatorID(), conversation.title(), lastMessage);
    }

    public ConversationPreload(Conversation conversation) {
        this(conversation.conversationID(), conversation.creatorID(), conversation.title(), null);
    }
}
