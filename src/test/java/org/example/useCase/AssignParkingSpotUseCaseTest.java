package org.example.useCase;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.commands.AssignParkingSpot;
import org.example.domain.entryCard.events.AssignedParkingSpot;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AssignParkingSpotUseCaseTest {

    private AssignParkingSpotUseCase assignParkingSpotUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    void setUp(){
        assignParkingSpotUseCase = new AssignParkingSpotUseCase();
        repository = mock(DomainEventRepository.class);
        assignParkingSpotUseCase.addRepository(repository);
    }

    @Test
    void assignGoodPath(){
        //Arrange
        var entryCardId = EntryCardId.of("E-65483");
        var parkingSpotId = ParkingSpotId.of("P-54135");

        var command = new AssignParkingSpot(entryCardId, parkingSpotId);

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(assignParkingSpotUseCase, new RequestCommand<>(command));

        var event = response.orElseThrow().getDomainEvents();

        AssignedParkingSpot assignedParkingSpot = (AssignedParkingSpot) event.get(0);

        //Assert
        Assertions.assertEquals("P-54135", assignedParkingSpot.getParkingSpotId().value());

    }

    @Test
    void assignBadPath(){
        //Arrange
        var entryCardId = EntryCardId.of("E-65483");
        var parkingSpotId = ParkingSpotId.of("P-54135");

        var command = new AssignParkingSpot(entryCardId, parkingSpotId);

        when(repository.getEventsBy(any())).thenReturn(events2());

        //Act and Assert
        var response = Assertions.assertThrows(BusinessException.class,()-> UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(assignParkingSpotUseCase, new RequestCommand<>(command)).orElseThrow());

        Assertions.assertEquals("The maximum of parking spot for entryCard is 3", response.getMessage());
    }


    private List<DomainEvent> events() {
        return List.of(new CreatedEntryCard(
                        EntryCardId.of("E-51236"),
                        AccountId.of("A-26541")
                ), new AssignedParkingSpot(
                        EntryCardId.of("E-51236"),
                        ParkingSpotId.of("P-54134"))
        );
    }

    private List<DomainEvent> events2() {
        return List.of(new CreatedEntryCard(
                        EntryCardId.of("E-51236"),
                        AccountId.of("A-26541")
                ), new AssignedParkingSpot(
                        EntryCardId.of("E-51236"),
                        ParkingSpotId.of("P-54132")),
                new AssignedParkingSpot(
                        EntryCardId.of("E-51236"),
                        ParkingSpotId.of("P-54133")),
                new AssignedParkingSpot(
                        EntryCardId.of("E-51236"),
                        ParkingSpotId.of("P-54134")),
                new AssignedParkingSpot(
                        EntryCardId.of("E-51236"),
                        ParkingSpotId.of("P-54131"))
        );
    }
}