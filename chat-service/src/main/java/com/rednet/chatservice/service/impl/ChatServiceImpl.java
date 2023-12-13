package com.rednet.chatservice.service.impl;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.entity.ConversationMember;
import com.rednet.chatservice.entity.ConversationPreload;
import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.entity.key.MessageKey;
import com.rednet.chatservice.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public List<ConversationPreload> getConversationsPreload(String userID) {
        return null;
    }

    @Override
    public Conversation createConversation(String creatorID, List<String> conversationMembersIDs, String title) {
        return null;
    }

    @Override
    public List<Message> getLastMessages(ConversationKey conversationKey, int count, String userID) {
        return null;
    }

    @Override
    public List<Message> getMessagesFrom(MessageKey messageKey, int count, String userID) {
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

    @Override
    public List<ConversationMember> getConversationMembers(ConversationKey conversationKey) {
        return null;
    }

    @Override
    public void addConversationMembers(ConversationKey conversationKey, List<String> userIDs, String executorID) {

    }

    @Override
    public void removeConversationMembers(ConversationKey conversationKey, List<String> userIDs, String executorID) {

    }
}
