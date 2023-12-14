package com.rednet.chatservice.controller;

import com.rednet.chatservice.service.ChatService;

public abstract class ChatServiceController {
    protected final ChatService chatService;

    public ChatServiceController(ChatService chatService) {
        this.chatService = chatService;
    }
}
