package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.commands.AssignMealPlan;
import org.example.domain.entryCard.commands.UpdateQuantityPeopleMealPlan;
import org.example.domain.entryCard.events.AssignedMealPlan;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.IsVegetarian;
import org.example.domain.entryCard.values.MealPlanId;
import org.example.domain.entryCard.values.QuantityPeople;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AssignMealPlanUseCaseTest {

    private AssignMealPlanUseCase assignMealPlanUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach
    void setUp(){
        assignMealPlanUseCase = new AssignMealPlanUseCase();
        repository = mock(DomainEventRepository.class);
        assignMealPlanUseCase.addRepository(repository);
    }

    @Test
    void createGoodPath(){
        var entryCardId = EntryCardId.of("E-51236");

        //Arrange
        var command = new AssignMealPlan(
                entryCardId,
                MealPlanId.of("M-25684"),
                new IsVegetarian("True"),
                new QuantityPeople("6"));

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(assignMealPlanUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        AssignedMealPlan assignedMealPlan = (AssignedMealPlan) events.get(0);
        Assertions.assertEquals("M-25684", assignedMealPlan.getMealPlanId().value());
        Assertions.assertEquals("6", assignedMealPlan.getQuantityPeople().value());
        Assertions.assertEquals("True", assignedMealPlan.getIsVegetarian().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CreatedEntryCard(
                        EntryCardId.of("E-51236"),
                        AccountId.of("A-26541")
                )
        );
    }
}
