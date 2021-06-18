package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.domain.account.events.CreatedAccount;
import org.example.services.AccountService;
import org.example.services.SenderTextMessageService;

public class NotifyTextMessageUseCase extends UseCase<TriggeredEvent<CreatedAccount>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CreatedAccount> createdAccountTriggeredEvent) {
        var event = createdAccountTriggeredEvent.getDomainEvent();
        var accountService = getService(AccountService.class).orElseThrow();

        var senderTextMessageService = getService(SenderTextMessageService.class).orElseThrow();

        var phoneNumber = accountService.getPhoneNumberByAccountId(event.getAccountId());
        senderTextMessageService.sendTextMessage(phoneNumber, "Hey! It is a pleasure to having you in our system, " +
                "we are exited to have you soon.");
    }
}
