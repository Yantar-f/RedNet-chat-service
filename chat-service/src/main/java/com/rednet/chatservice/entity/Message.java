package com.rednet.chatservice.entity;

import java.time.Instant;

public record Message (String conversationID, String creatorID, Instant timestamp, String senderID, String text) {
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (! (obj instanceof Message message)) return false;

        return  message.conversationID.equals(conversationID) &&
                message.creatorID.equals(creatorID) &&
                message.senderID.equals(senderID) &&
                message.text.equals(text) &&
                message.timestamp.equals(timestamp);
    }

    @Override
    public int hashCode() {
        return  conversationID.hashCode() *
                creatorID.hashCode() *
                senderID.hashCode() *
                text.hashCode() *
                timestamp.hashCode();
    }
}
