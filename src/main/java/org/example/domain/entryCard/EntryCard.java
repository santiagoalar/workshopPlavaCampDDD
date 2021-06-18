package org.example.domain.entryCard;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.events.AssignedCottage;
import org.example.domain.entryCard.events.AssignedMealPlan;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.events.UpdatedQuantityPeopleMealPlan;
import org.example.domain.entryCard.values.*;

import java.util.List;

public class EntryCard extends AggregateEvent<EntryCardId> {

    protected ArrivalDate arrivalDate;
    protected DepartureDate departureDate;
    protected AccountId accountId;
    protected MealPlanId mealPlanId;
    protected CottageId cottageId;


    public EntryCard(EntryCardId entityId, AccountId accountId) {
        super(entityId);
        appendChange(new CreatedEntryCard(entityId, accountId)).apply();
    }

    private EntryCard(EntryCardId entryCardId){
        super(entryCardId);
        subscribe(new OnChangeEntryCard(this));
    }

    public static EntryCard from(EntryCardId entryCardId, List<DomainEvent> events){
        var entryCard = new EntryCard(entryCardId);
        events.forEach(entryCard::applyEvent);
        return entryCard;
    }

    public void assignCottage(EntryCardId entryCardId, CottageId cottageId){
        appendChange(new AssignedCottage(entryCardId, cottageId));
    }

    public void assignMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, IsVegetarian isVegetarian, QuantityPeople quantityPeople){
        appendChange(new AssignedMealPlan(entryCardId, mealPlanId, isVegetarian, quantityPeople));
    }

    public void updateQuantityPeopleMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, QuantityPeople quantityPeople){
        appendChange(new UpdatedQuantityPeopleMealPlan(entryCardId, mealPlanId, quantityPeople));
    }
}
