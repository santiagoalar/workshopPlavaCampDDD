package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.MealPlanId;
import org.example.domain.entryCard.values.QuantityPeople;

public class UpdateQuantityPeopleMealPlan implements Command {

    private final EntryCardId entryCardId;
    private final MealPlanId mealPlanId;
    private final QuantityPeople quantityPeople;

    public UpdateQuantityPeopleMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, QuantityPeople quantityPeople) {
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
