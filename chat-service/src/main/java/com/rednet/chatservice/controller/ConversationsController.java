package com.rednet.chatservice.controller;

import com.rednet.chatservice.entity.Conversation;
import com.rednet.chatservice.entity.ConversationMember;
import com.rednet.chatservice.model.ConversationPreload;
import com.rednet.chatservice.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/conversations")
public class ConversationsController extends ChatServiceController {
    public ConversationsController(ChatService chatService) {
        super(chatService);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Conversation> createConversation() {
        return ResponseEntity.ok(chatService.createConversation(null, null, null));
    }

    @GetMapping(path = "/preload", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConversationPreload>> getConversationsPreload() {
        return ResponseEntity.ok(chatService.getConversationsPreload(null));
    }

    @GetMapping(path = "/members", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConversationMember>> getConversationMembers() {
        return ResponseEntity.ok(chatService.getConversationMembers(null, null));
    }

    @PostMapping(path = "/members")
    public ResponseEntity<List<ConversationMember>> addConversationMembers() {
        chatService.addConversationMembers(null, null, null);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping(path = "/members")
    public ResponseEntity<List<ConversationMember>> removeConversationMembers() {
        chatService.removeConversationMembers(null, null, null);
        return ResponseEntity.status(200).build();
    }

    @PostMapping(path = "/notifications")
    public ResponseEntity<Void> disableNotifications() {
        chatService.disableConversationNotifications(null, null);
        return ResponseEntity.status(200).build();
    }

    @PostMapping(path = "/notifications")
    public ResponseEntity<Void> enableNotifications() {
        chatService.enableConversationNotifications(null, null);
        return ResponseEntity.status(200).build();
    }
}
