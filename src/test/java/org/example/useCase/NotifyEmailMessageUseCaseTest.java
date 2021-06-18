package org.example.useCase;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.Email;
import org.example.domain.account.values.PhoneNumber;
import org.example.genericValues.Name;
import org.example.services.AccountService;
import org.example.services.SenderEmailMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotifyEmailMessageUseCaseTest {

    private NotifyEmailMessageUseCase notifyEmailMessageUseCase;
    private AccountService accountService;
    private SenderEmailMessageService senderEmailMessageService;

    @BeforeEach
    void setUp(){
        notifyEmailMessageUseCase = new NotifyEmailMessageUseCase();
        accountService = mock(AccountService.class);
        senderEmailMessageService = mock(SenderEmailMessageService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(accountService)
                .addService(senderEmailMessageService);
        notifyEmailMessageUseCase.addServiceBuilder(builder);
    }

    @Test
    void notifyEmailGoodPAth(){
        //Arrange
        var accountId = AccountId.of("A-36122");
        var event = new CreatedAccount(
                accountId,
                new Name("Santiago"),
                new Age("28"),
                new Email("santiago@mail.com"),
                new PhoneNumber("3156655812"));

        when(accountService.getEmailByAccountId(any())).thenReturn(event.getEmail());
        doNothing().when(senderEmailMessageService).sendEmailMessage(any(), any());

        //Act
        UseCaseHandler.getInstance().syncExecutor(notifyEmailMessageUseCase, new TriggeredEvent<>(event));

        //Assert
        verify(accountService).getEmailByAccountId(any());
        verify(senderEmailMessageService).sendEmailMessage(any(),any());
    }

}