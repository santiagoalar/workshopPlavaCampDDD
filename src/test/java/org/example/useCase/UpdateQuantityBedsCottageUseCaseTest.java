package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.commands.UpdateQuantityBedsCottage;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.events.UpdatedQuantityBedsCottage;
import org.example.domain.entryCard.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UpdateQuantityBedsCottageUseCaseTest {

    private UpdateQuantityBedsCottageUseCase updateQuantityBedsCottageUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    void setUp(){
        updateQuantityBedsCottageUseCase = new UpdateQuantityBedsCottageUseCase();
        repository = mock(DomainEventRepository.class);
        updateQuantityBedsCottageUseCase.addRepository(repository);
    }

    @Test
    void createGoodPath(){

        //Arrange
        var entryCardId = EntryCardId.of("E-51236");

        var command = new UpdateQuantityBedsCottage(entryCardId, CottageId.of("C-64892"), new QuantityBeds("6"));

        when(repository.getEventsBy(any())).thenReturn(events());
        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(updateQuantityBedsCottageUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        UpdatedQuantityBedsCottage updatedQuantityBedsCottage = (UpdatedQuantityBedsCottage) events.get(0);
        Assertions.assertEquals("6", updatedQuantityBedsCottage.getQuantityBeds().value());
        Assertions.assertEquals("C-64892", updatedQuantityBedsCottage.getCottageId().value());

    }

    private List<DomainEvent> events() {
        return List.of(new CreatedEntryCard(
                        EntryCardId.of("E-51236"),
                        AccountId.of("A-26541")
                ), new UpdatedQuantityBedsCottage(
                        EntryCardId.of("E-51236"),
                        CottageId.of("C-64892"),
                        new QuantityBeds("2"))
        );
    }
}