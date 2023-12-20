package com.rednet.chatservice.model;

import com.rednet.chatservice.entity.Message;

import java.time.Instant;

public record MessageModel(Instant timestamp, String senderID, String text) {
    public MessageModel(Message message) {
        this(message.timestamp(), message.senderID(), message.text());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (! (obj instanceof MessageModel model)) return false;

        return  model.senderID.equals(senderID) && model.text.equals(text) && model.timestamp.equals(timestamp);
    }

    @Override
    public int hashCode() {
        return senderID.hashCode() * text.hashCode() * timestamp.hashCode();
    }
}
