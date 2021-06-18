package org.example.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import org.example.domain.account.commands.UpdateName;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.events.UpdatedName;
import org.example.domain.account.values.AccountId;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.Email;
import org.example.domain.account.values.PhoneNumber;
import org.example.genericValues.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UpdateNameAccountUseCaseTest {

    private UpdateNameAccountUseCase updateNameAccountUseCase;

    @BeforeEach
    public void setUp(){
        updateNameAccountUseCase = new UpdateNameAccountUseCase();
    }

    @Mock
    private DomainEventRepository repository;

    @Test
    void createGoodPath(){

        //Arrange
        var name = new Name("Carlos Francisco");
        var accountId = AccountId.of("F-3125");
        UpdateName updateName = new UpdateName(accountId, name);

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedAccount(
                        accountId,
                        new Name("Alberto"),
                        new Age("32"),
                        new Email("ant@mail.com"), new PhoneNumber("3125669856")
                )));

        updateNameAccountUseCase.addRepository(repository);

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(accountId.value())
                .syncExecutor(updateNameAccountUseCase, new RequestCommand<>(updateName));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        UpdatedName updatedName = (UpdatedName) events.get(0);
        Assertions.assertEquals("Carlos Francisco", updatedName.getName().value());

    }
}