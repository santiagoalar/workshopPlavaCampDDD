package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.Identity;

public class MealPlanId extends Identity {

    public MealPlanId() {
    }

    private MealPlanId(String id){
        super(id);
    }

    public static MealPlanId of(String id){
        return new MealPlanId(id);
    }
}
