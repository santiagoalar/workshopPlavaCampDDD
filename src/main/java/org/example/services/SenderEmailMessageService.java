package org.example.services;

import org.example.domain.account.values.Email;

public interface SenderEmailMessageService {
    void sendEmailMessage(Email email, String content);
}
