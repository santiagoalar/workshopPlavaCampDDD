package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.MealPlanId;

public class AssignedMealPlan extends DomainEvent {

    private final EntryCardId entryCardId;
    private final MealPlanId mealPlanId;

    public AssignedMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId) {
        super("plavaCamp.entryCard.assignedMealPlan");
        this.entryCardId = entryCardId;
        this.mealPlanId = mealPlanId;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public MealPlanId getMealPlanId() {
        return mealPlanId;
    }

}
