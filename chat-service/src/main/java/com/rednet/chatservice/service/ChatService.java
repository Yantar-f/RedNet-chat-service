package com.rednet.chatservice.service;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.entity.ConversationMember;
import com.rednet.chatservice.model.ConversationPreload;
import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.entity.key.ConversationKey;
import com.rednet.chatservice.entity.key.MessageKey;
import com.rednet.chatservice.model.MessageModel;

import java.util.List;

public interface ChatService {
    List<ConversationPreload>   getConversationsPreload     (String userID);
    Conversation                createConversation          (String creatorID, List<String> conversationMembersIDs, String title);
    List<ConversationMember>    getConversationMembers      (ConversationKey conversationKey, String userID);
    void                        addConversationMembers      (ConversationKey conversationKey, List<String> userIDs, String executorID);
    void                        removeConversationMembers   (ConversationKey conversationKey, List<String> userIDs, String executorID);

    List<MessageModel>   getLastMessages         (ConversationKey conversationKey, int count, String userID);
    List<MessageModel>   getPreviousMessagesFrom (MessageKey messageKey, int count, String userID);
    List<MessageModel>   getNextMessagesFrom     (MessageKey messageKey, int count, String userID);

    Message         pushMessage             (ConversationKey conversationKey, String text, String userID);
    Message         editMessage             (MessageKey messageKey, String text, String userID);
    void            deleteMessages          (List<MessageKey> messageKeys, String userID);

    void disableConversationNotifications   (ConversationKey conversationKey, String userID);
    void enableConversationNotifications    (ConversationKey conversationKey, String userID);

}
