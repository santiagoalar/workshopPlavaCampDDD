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
import org.example.services.SenderTextMessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotifyTextMessageUseCaseTest {

    private NotifyTextMessageUseCase notifyTextMessageUseCase;
    private AccountService accountService;
    private SenderTextMessageService senderTextMessageService;

    @BeforeEach
    void setUp(){
        notifyTextMessageUseCase = new NotifyTextMessageUseCase();

        accountService = mock(AccountService.class);
        senderTextMessageService = mock(SenderTextMessageService.class);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(accountService)
                .addService(senderTextMessageService);
        notifyTextMessageUseCase.addServiceBuilder(builder);
    }

    @Test
    void sendTextMessageGoodPath(){
        //Arrange
        var accountId = AccountId.of("A-36122");
        var event = new CreatedAccount(
                        accountId,
                        new Name("Santiago"),
                        new Age("28"),
                        new Email("santiago@mail.com"),
                        new PhoneNumber("3156655812"));

        when(accountService.getPhoneNumberByAccountId(any())).thenReturn(event.getPhoneNumber());
        doNothing().when(senderTextMessageService).sendTextMessage(any(),any());

        //Act
        UseCaseHandler.getInstance()
                .syncExecutor(notifyTextMessageUseCase, new TriggeredEvent<>(event));

        //Assert
        verify(accountService).getPhoneNumberByAccountId(any());
        verify(senderTextMessageService).sendTextMessage(any(), any());

    }
}