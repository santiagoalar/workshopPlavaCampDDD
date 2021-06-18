package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.MealPlanId;
import org.example.domain.entryCard.values.QuantityPeople;

public class UpdatedQuantityPeopleMealPlan extends DomainEvent {

    private final EntryCardId entryCardId;
    private final MealPlanId mealPlanId;
    private final QuantityPeople quantityPeople;

    public UpdatedQuantityPeopleMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, QuantityPeople quantityPeople) {
        super("plavaCamp.entryCard.updatedQuantityPeopleMealPlan");
        this.entryCardId = entryCardId;
        this.mealPlanId = mealPlanId;
        this.quantityPeople = quantityPeople;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public MealPlanId getMealPlanId() {
        return mealPlanId;
    }

    public QuantityPeople getQuantityPeople() {
        return quantityPeople;
    }
}
