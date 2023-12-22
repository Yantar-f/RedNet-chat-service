package com.rednet.chatservice.model;

import com.rednet.chatservice.entity.Conversation;

import java.util.Optional;

public record ConversationPreload(String conversationID, String creatorID, String title, Optional<MessageModel> lastMessage) {
    public ConversationPreload(Conversation conversation, MessageModel lastMessage) {
        this(conversation.conversationID(), conversation.creatorID(), conversation.title(), Optional.of(lastMessage));
    }
    public ConversationPreload(Conversation conversation) {
        this(conversation.conversationID(), conversation.creatorID(), conversation.title(), Optional.empty());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (! (obj instanceof ConversationPreload preload)) return false;

        return  preload.conversationID.equals(conversationID) &&
                preload.creatorID.equals(creatorID) &&
                preload.title.equals(title) &&
                preload.lastMessage.equals(lastMessage);
    }

    @Override
    public int hashCode() {
        return conversationID.hashCode() * creatorID.hashCode() * title.hashCode() * lastMessage.hashCode();
    }
}
