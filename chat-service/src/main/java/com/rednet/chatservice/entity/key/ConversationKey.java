package com.rednet.chatservice.entity.key;

public record ConversationKey(String conversationID, String creatorID) {
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (! (obj instanceof ConversationKey key)) return false;

        return key.conversationID.equals(conversationID) && key.creatorID.equals(creatorID);
    }

    @Override
    public int hashCode() {
        return conversationID.hashCode() * creatorID.hashCode();
    }
}
