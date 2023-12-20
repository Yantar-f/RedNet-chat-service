package com.rednet.chatservice.entity.key;

import java.time.Instant;

public record MessageKey (String conversationID, String creatorID, Instant timestamp, String senderID) {
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (! (obj instanceof MessageKey key)) return false;

        return  key.conversationID.equals(conversationID) &&
                key.creatorID.equals(creatorID) &&
                key.senderID.equals(senderID) &&
                key.timestamp.equals(timestamp);
    }

    @Override
    public int hashCode() {
        return  conversationID.hashCode() * creatorID.hashCode() * senderID.hashCode() * timestamp.hashCode();
    }
}
