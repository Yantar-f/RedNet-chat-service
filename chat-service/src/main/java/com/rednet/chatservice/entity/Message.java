package com.rednet.chatservice.entity;

import java.time.Instant;

public record Message (String conversationID, String creatorID, Instant timestamp, String senderID, String text) {}
