package org.example.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.commands.UpdateQuantityPeopleMealPlan;
import org.example.domain.entryCard.events.AssignedMealPlan;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.events.UpdatedQuantityPeopleMealPlan;
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

class UpdateQuantityPeopleMealPlanUseCaseTest {

    private UpdateQuantityPeopleMealPlanUseCase updateQuantityPeopleMealPlanUseCase;

    @Mock
    private DomainEventRepository repository;

    @BeforeEach void setUp(){
        updateQuantityPeopleMealPlanUseCase = new UpdateQuantityPeopleMealPlanUseCase();
        repository = mock(DomainEventRepository.class);
        updateQuantityPeopleMealPlanUseCase.addRepository(repository);
    }

    @Test
    void createGooPath(){
        var entryCardId = EntryCardId.of("E-51236");

        //Arrange
        var command = new UpdateQuantityPeopleMealPlan(
                EntryCardId.of("E-51236"),
                MealPlanId.of("M-25684"),
                new QuantityPeople("6"));

        when(repository.getEventsBy(any())).thenReturn(events());

        //Act
        var response = UseCaseHandler.getInstance()
                .setIdentifyExecutor(entryCardId.value())
                .syncExecutor(updateQuantityPeopleMealPlanUseCase, new RequestCommand<>(command));

        var events = response.orElseThrow().getDomainEvents();

        //Assert
        UpdatedQuantityPeopleMealPlan updatedQuantityPeopleMealPlan = (UpdatedQuantityPeopleMealPlan) events.get(0);
        Assertions.assertEquals("6", updatedQuantityPeopleMealPlan.getQuantityPeople().value());
        Assertions.assertEquals("M-25684", updatedQuantityPeopleMealPlan.getMealPlanId().value());
    }

    private List<DomainEvent> events() {
        return List.of(new CreatedEntryCard(
                EntryCardId.of("E-51236"),
                AccountId.of("A-26541")
        ), new AssignedMealPlan(
                EntryCardId.of("E-51236"),
                MealPlanId.of("M-25684"),
                new IsVegetarian("True"),
                new QuantityPeople("2"))
        );
    }




}