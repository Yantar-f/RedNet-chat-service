package com.rednet.chatservice.service;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.entity.ConversationPreload;
import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.entity.key.MessageKey;

import java.util.List;

public interface ChatService {
    List<ConversationPreload> getConversationsPreload   (String userID);
    Conversation createConversation                     (String creatorID, List<String> conversationMembersIDs, String title);

    List<Message> getLastMessages   (ConversationKey conversationKey, int count, String userID);
    List<Message> getMessagesFrom   (MessageKey messageKey, int count, String userID);
    Message pushMessage             (ConversationKey conversationKey, String text, String userID);
    Message editMessage             (MessageKey messageKey, String text, String userID);
    void deleteMessages             (List<MessageKey> messageKeys, String userID);

    void disableConversationNotifications   (ConversationKey conversationKey, String userID);
    void enableConversationNotifications    (ConversationKey conversationKey, String userID);

    List<String> getConversationMembersIDs  (ConversationKey conversationKey);
    void addConversationMembers             (ConversationKey conversationKey, List<String> userIDs, String executorID);
    void removeConversationMembers          (ConversationKey conversationKey, List<String> userIDs, String executorID);
}
