package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.EntryCard;
import org.example.domain.entryCard.commands.AssignAccount;
import org.example.domain.entryCard.events.AssignedAccount;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.values.EntryCardId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AssignAccountUseCaseTest {

    private AssignAccountUseCase assignAccountUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    void setUp(){
        assignAccountUseCase = new AssignAccountUseCase();
        repository = mock(DomainEventRepository.class);
        assignAccountUseCase.addRepository(repository);
    }

    @Test
    void createGoodPath(){
        var entryCardId = EntryCardId.of("E-25648");

        var command = new AssignAccount(entryCardId, AccountId.of("A-256479"));

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(assignAccountUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        AssignedAccount assignedAccount = (AssignedAccount) events.get(0);
        Assertions.assertEquals("A-256479", assignedAccount.getAccountId().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CreatedEntryCard(
                        EntryCardId.of("E-51236"),
                        AccountId.of("A-26541")
                )
        );
    }

}