package com.rednet.chatservice.entity;

public record ConversationPreload(
    String conversationID,
    String creatorID,
    String title,
    Message lastMessage
) {}
