package org.example.domain.entryCard;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.entryCard.values.IsVegetarian;
import org.example.domain.entryCard.values.MealPlanId;
import org.example.domain.entryCard.values.QuantityPeople;

public class MealPlan extends Entity<MealPlanId> {

    private IsVegetarian isVegetarian;
    private QuantityPeople quantityPeople;

    public MealPlan(MealPlanId entityId, IsVegetarian isVegetarian, QuantityPeople quantityPeople) {
        super(entityId);
        this.isVegetarian = isVegetarian;
        this.quantityPeople = quantityPeople;
    }

    public void updateIsVegetarian(IsVegetarian isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

    public void updateQuantityPeople(QuantityPeople quantityPeople) {
        this.quantityPeople = quantityPeople;
    }

    public IsVegetarian getIsVegetarian() {
        return isVegetarian;
    }

    public QuantityPeople getQuantityPeople() {
        return quantityPeople;
    }

}
