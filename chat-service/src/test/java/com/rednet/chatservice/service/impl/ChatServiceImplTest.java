package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.model.ConversationPreload;
import com.rednet.chatservice.model.MessageModel;
import com.rednet.chatservice.service.ChatService;
import com.rednet.chatservice.service.ConversationService;
import com.rednet.chatservice.service.MessageService;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ChatServiceImplTest {
    private static final int TEST_REPETITIONS_COUNT = 3;
    Random  rand = new Random();
    int     stringLengthBound = 200;
    private final MessageService        messageService = mock(MessageService.class);
    private final ConversationService   conversationService = mock(ConversationService.class);
    private final ChatService           chatService = new ChatServiceImpl(conversationService, messageService);
    private final String expectedUserID = randString();

    @AfterEach
    public void after() {
        verifyNoMoreInteractions(messageService, conversationService);
    }

    @RepeatedTest(TEST_REPETITIONS_COUNT)
    void getConversationsPreload() {
        int conversationsCount = rand.nextInt(20);

        List<Conversation>          expectedConversations = new ArrayList<>();
        List<ConversationKey>       expectedConversationKeys = new ArrayList<>();
        List<Message>               expectedMessages = new ArrayList<>();
        List<ConversationPreload>   expectedConversationsPreload = new ArrayList<>();

        for (int i = 0; i < conversationsCount; ++i) {
            ConversationKey conversationKey = new ConversationKey(randString(), randString());
            Conversation    conversation = new Conversation(conversationKey, randString());

            Message message = new Message(
                    conversation.conversationID(),
                    conversation.creatorID(),
                    Instant.now(),
                    randString(),
                    randString()
            );

            expectedConversationKeys.add(conversationKey);
            expectedConversations.add(conversation);
            expectedMessages.add(message);
            expectedConversationsPreload.add(new ConversationPreload(conversation, new MessageModel(message)));
        }

        when(conversationService.getConversationsByUserID(any())).thenReturn(expectedConversations);
        when(messageService.getLastMessagesPerConversation(any())).thenReturn(expectedMessages);

        assertDoesNotThrow(() -> {
            List<ConversationPreload> actualConversationsPreload = chatService.getConversationsPreload(expectedUserID);

            assertEquals(expectedConversationsPreload.size(), actualConversationsPreload.size());
            assertTrue(expectedConversationsPreload.containsAll(actualConversationsPreload));
        });

        verify(conversationService).getConversationsByUserID(eq(expectedUserID));
        verify(messageService).getLastMessagesPerConversation(argThat(actualKeys ->
                expectedConversationKeys.size() == actualKeys.size() &&
                expectedConversationKeys.containsAll(actualKeys)
        ));
    }

    @RepeatedTest(TEST_REPETITIONS_COUNT)
    void createConversation() {
        List<String> expectedMembersIDs = new ArrayList<>();
        Conversation expectedConversation = new Conversation(randString(), randString(), randString());

        when(conversationService.createConversation(any(), any(), any())).thenReturn(expectedConversation);

        assertDoesNotThrow(() -> {
            Conversation actualConversation = chatService.createConversation(
                    expectedConversation.creatorID(),
                    expectedMembersIDs,
                    expectedConversation.title()
            );

            assertEquals(expectedConversation, actualConversation);
        });

        verify(conversationService).createConversation(
                eq(expectedConversation.conversationID()),
                argThat(expectedMembersIDs::containsAll),
                eq(expectedConversation.title())
        );
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

    private int randStringLength() {
        return rand.nextInt(stringLengthBound - 1) + 1;
    }

    private String randString() {
        return RandomStringUtils.random(randStringLength());
    }
}