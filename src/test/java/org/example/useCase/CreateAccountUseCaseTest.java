package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.domain.account.commands.CreateAccount;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.values.*;
import org.example.genericValues.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAccountUseCaseTest {
    private CreateAccountUseCase createAccountUseCase;

    @BeforeEach
    public void setUp() {
        createAccountUseCase = new CreateAccountUseCase();
    }

    @Test
    void createGuestGoodPath() {
        //Arrange
        var command = new CreateAccount(AccountId.of("5126985"), new Name("Alvaro"),
                new Age("25"), new Email("alva@gmail.com"), new PhoneNumber("316559903"));

        //Act
        var response = UseCaseHandler.getInstance()
                .syncExecutor(createAccountUseCase, new RequestCommand<>(command));
        var events = response.orElseThrow().getDomainEvents();

        //Assert
        CreatedAccount createdAccount = (CreatedAccount) events.get(0);
        Assertions.assertEquals("Alvaro", createdAccount.getName().value());
        Assertions.assertEquals("25", createdAccount.getAge().value());
        Assertions.assertEquals("alva@gmail.com", createdAccount.getEmail().value());
        Assertions.assertEquals("316559903", createdAccount.getPhoneNumber().value());

    }
}