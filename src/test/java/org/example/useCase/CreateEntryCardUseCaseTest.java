package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.example.domain.account.events.CreatedAccount;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.commands.CreateEntryCard;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.values.EntryCardId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEntryCardUseCaseTest {

    private CreateEntryCardUseCase createEntryCardUseCase;

    @BeforeEach
    public void setUp() {
        createEntryCardUseCase = new CreateEntryCardUseCase();
    }

    @Test
    void createGoodPath(){
        //Arrange
        var entryCardId = EntryCardId.of("E-2365");
        var accountId = AccountId.of("A-9846");

        var command = new CreateEntryCard(entryCardId, accountId);

        //Act
        var response = UseCaseHandler.getInstance()
                .syncExecutor(createEntryCardUseCase, new RequestCommand<>(command));
        var events = response.orElseThrow().getDomainEvents();

        //Assert
        CreatedEntryCard createdEntryCard = (CreatedEntryCard) events.get(0);
        Assertions.assertEquals("A-9846", createdEntryCard.getAccountId().value());
    }
}