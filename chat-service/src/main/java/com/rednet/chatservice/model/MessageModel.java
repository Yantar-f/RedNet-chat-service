package com.rednet.chatservice.model;

import com.rednet.chatservice.entity.Message;

import java.time.Instant;

public record MessageModel(Instant timestamp, String senderID, String text) {
    public MessageModel(Message message) {
        this(message.timestamp(), message.senderID(), message.text());
    }
}
