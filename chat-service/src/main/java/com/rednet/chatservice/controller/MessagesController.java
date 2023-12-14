package com.rednet.chatservice.controller;

import com.rednet.chatservice.entity.Message;
import com.rednet.chatservice.model.MessageModel;
import com.rednet.chatservice.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/messages")
public class MessagesController extends ChatServiceController {
    public MessagesController(ChatService chatService) {
        super(chatService);
    }

    @GetMapping(path = "/last", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageModel>> getLastMessages() {
        return ResponseEntity.ok(chatService.getLastMessages(null, 0, null));
    }

    @GetMapping(path = "/previous-from", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageModel>> getPreviousMessagesFrom() {
        return ResponseEntity.ok(chatService.getPreviousMessagesFrom(null, 0, null));
    }

    @GetMapping(path = "/next-from", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessageModel>> getNextMessagesFrom() {
        return ResponseEntity.ok(chatService.getNextMessagesFrom(null, 0, null));
    }

    @PostMapping
    public ResponseEntity<Message> pushMessage() {
        return ResponseEntity.ok(chatService.pushMessage(null, null, null));
    }

    @PutMapping
    public ResponseEntity<Message> editMessage() {
        return ResponseEntity.ok(chatService.editMessage(null, null, null));
    }

    @DeleteMapping
    public ResponseEntity<Message> deleteMessage() {
        chatService.deleteMessages(null, null);
        return ResponseEntity.status(200).build();
    }
}
