package org.example.services;

import org.example.domain.account.values.PhoneNumber;

public interface SenderTextMessageService {
    void sendTextMessage(PhoneNumber phoneNumber, String content);
}
