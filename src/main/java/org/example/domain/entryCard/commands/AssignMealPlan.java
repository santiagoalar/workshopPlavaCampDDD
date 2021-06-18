package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.IsVegetarian;
import org.example.domain.entryCard.values.MealPlanId;
import org.example.domain.entryCard.values.QuantityPeople;

public class AssignMealPlan implements Command {

    private final EntryCardId entryCardId;
    private final MealPlanId mealPlanId;
    private final IsVegetarian isVegetarian;
    private final QuantityPeople quantityPeople;

    public AssignMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, IsVegetarian isVegetarian, QuantityPeople quantityPeople) {
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
