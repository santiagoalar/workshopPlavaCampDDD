package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.IsVegetarian;
import org.example.domain.entryCard.values.MealPlanId;
import org.example.domain.entryCard.values.QuantityPeople;

public class AssignedMealPlan extends DomainEvent {

    private final EntryCardId entryCardId;
    private final MealPlanId mealPlanId;
    private final IsVegetarian isVegetarian;
    private final QuantityPeople quantityPeople;

    public AssignedMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, IsVegetarian isVegetarian, QuantityPeople quantityPeople) {
        super("plavaCamp.entryCard.assignedMealPlan");
        this.entryCardId = entryCardId;
        this.mealPlanId = mealPlanId;
        this.isVegetarian = isVegetarian;
        this.quantityPeople = quantityPeople;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public MealPlanId getMealPlanId() {
        return mealPlanId;
    }

    public IsVegetarian getIsVegetarian() {
        return isVegetarian;
    }

    public QuantityPeople getQuantityPeople() {
        return quantityPeople;
    }
}
