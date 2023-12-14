package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.service.ChatService;
import com.rednet.chatservice.service.ConversationService;
import com.rednet.chatservice.service.MessageService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ChatServiceImplTest {

    private final MessageService messageService = mock(MessageService.class);
    private final ConversationService conversationService  = mock(ConversationService.class);
    private final ChatService chatService = new ChatServiceImpl(conversationService, messageService);


    @Test
    void getConversationsPreload() {
    }

    @Test
    void createConversation() {
    }

    @Test
    void getLastMessages() {
    }

    @Test
    void getPreviousMessagesFrom() {
    }

    @Test
    void getNextMessagesFrom() {
    }

    @Test
    void pushMessage() {
    }

    @Test
    void editMessage() {
    }

    @Test
    void deleteMessages() {
    }

    @Test
    void disableConversationNotifications() {
    }

    @Test
    void enableConversationNotifications() {
    }

    @Test
    void getConversationMembers() {
    }

    @Test
    void addConversationMembers() {
    }

    @Test
    void removeConversationMembers() {
    }
}