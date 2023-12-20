package com.rednet.chatservice.entity;

import com.rednet.chatservice.entity.key.ConversationKey;

public record Conversation (String conversationID, String creatorID, String title) {
    public Conversation(ConversationKey conversationKey, String title) {
        this(conversationKey.conversationID(), conversationKey.creatorID(), title);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (! (obj instanceof Conversation conversation)) return false;

        return  conversation.conversationID.equals(conversationID) &&
                conversation.creatorID.equals(creatorID) &&
                conversation.title.equals(title);
    }

    @Override
    public int hashCode() {
        return conversationID.hashCode() * creatorID.hashCode() * title.hashCode();
    }
}
