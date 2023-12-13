package com.rednet.chatservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatServiceController {
    @GetMapping
    public String hello() {
        return "Hello";
    }
}
