package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.Entity;

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
