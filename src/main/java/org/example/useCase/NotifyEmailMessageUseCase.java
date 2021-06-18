package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.domain.account.events.CreatedAccount;
import org.example.services.AccountService;
import org.example.services.SenderEmailMessageService;

public class NotifyEmailMessageUseCase extends UseCase<TriggeredEvent<CreatedAccount>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CreatedAccount> createdAccountTriggeredEvent) {
        var event = createdAccountTriggeredEvent.getDomainEvent();
        var accountService = getService(AccountService.class).orElseThrow();
        var senderTextMessageService = getService(SenderEmailMessageService.class).orElseThrow();

        var emailAccount = accountService.getEmailByAccountId(event.getAccountId());
        senderTextMessageService.sendEmailMessage(emailAccount, "Hey! We are so exited to having you in Plava Camp soon!");
    }
}
