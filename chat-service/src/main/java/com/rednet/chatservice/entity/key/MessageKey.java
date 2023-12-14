package com.rednet.chatservice.entity.key;

import java.time.Instant;

public record MessageKey (String conversationID, String creatorID, Instant timestamp, String senderID) {}
