package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.commands.AssignCottage;
import org.example.domain.entryCard.events.AssignedCottage;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.values.CottageId;
import org.example.domain.entryCard.values.EntryCardId;
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
class AssignCottageUseCaseTest {

    private AssignCottageUseCase assignCottageUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    public void setUp(){
        assignCottageUseCase = new AssignCottageUseCase();
    }

    @Test
    void createGoodPath(){
        //Arrange
        var entryCardId = EntryCardId.of("E-98989");
        var command = new AssignCottage(entryCardId, CottageId.of("C-54657"));

        when(repository.getEventsBy(anyString())).thenReturn(List.of(
                new CreatedEntryCard(entryCardId, AccountId.of("A-222222"))
        ));

        assignCottageUseCase.addRepository(repository);

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(assignCottageUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        AssignedCottage assignedCottage = (AssignedCottage) events.get(0);
        Assertions.assertEquals("C-54657", assignedCottage.getCottageId().value());

    }

}