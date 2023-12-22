package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.entity.ConversationMember;
import com.rednet.chatservice.model.ConversationPreload;
import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.entity.key.MessageKey;
import com.rednet.chatservice.model.MessageModel;
import com.rednet.chatservice.service.ChatService;
import com.rednet.chatservice.service.ConversationService;
import com.rednet.chatservice.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {
    private final ConversationService conversationService;
    private final MessageService messageService;

    public ChatServiceImpl(ConversationService conversationService, MessageService messageService) {
        this.conversationService = conversationService;
        this.messageService = messageService;
    }

    @Override
    public List<ConversationPreload> getConversationsPreload(String userID) {
        List<Conversation> conversations = conversationService.getConversationsByUserID(userID);
        List<Optional<Message>> lastMessages = messageService.getLastMessagesPerConversation(
                conversations
                        .stream()
                        .map(c -> new ConversationKey(c.conversationID(), c.creatorID()))
                        .toList());

        List<ConversationPreload> preload = new ArrayList<>(conversations.size());

        for (int length = conversations.size(), i = 0; i < length; ++i) {
            Conversation conversation = conversations.get(i);

            lastMessages.get(i).ifPresentOrElse(message -> {
                preload.add(new ConversationPreload(conversation, new MessageModel(message)));
            }, () -> {
                preload.add(new ConversationPreload(conversation));
            });
        }

        return preload;
    }

    @Override
    public Conversation createConversation(String creatorID, List<String> conversationMembersIDs, String title) {
        return null;
    }

    @Override
    public List<ConversationMember> getConversationMembers(ConversationKey conversationKey, String userID) {
        return null;
    }

    @Override
    public void addConversationMembers(ConversationKey conversationKey, List<String> userIDs, String executorID) {

    }

    @Override
    public void removeConversationMembers(ConversationKey conversationKey, List<String> userIDs, String executorID) {

    }

    @Override
    public List<MessageModel> getLastMessages(ConversationKey conversationKey, int count, String userID) {
        return null;
    }

    @Override
    public List<MessageModel> getPreviousMessagesFrom(MessageKey messageKey, int count, String userID) {
        return null;
    }

    @Override
    public List<MessageModel> getNextMessagesFrom(MessageKey messageKey, int count, String userID) {
        return null;
    }

    @Override
    public Message pushMessage(ConversationKey conversationKey, String text, String userID) {
        return null;
    }

    @Override
    public Message editMessage(MessageKey messageKey, String text, String userID) {
        return null;
    }

    @Override
    public void deleteMessages(List<MessageKey> messageKeys, String userID) {

    }

    @Override
    public void disableConversationNotifications(ConversationKey conversationKey, String userID) {

    }

    @Override
    public void enableConversationNotifications(ConversationKey conversationKey, String userID) {

    }
}
