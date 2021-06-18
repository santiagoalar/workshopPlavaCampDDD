package org.example.domain.entryCard;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.entryCard.events.*;

public class OnChangeEntryCard extends EventChange {

    public OnChangeEntryCard(EntryCard entryCard){
        apply((CreatedEntryCard event)->{
            entryCard.accountId = event.getAccountId();
        });

        apply(((AssignedCottage event)->{
            entryCard.cottageId = event.getCottageId();
        }));

        apply((UpdatedQuantityPeopleMealPlan event)->{
            entryCard.mealPlanId = event.getMealPlanId();

            //Algo mas
        });

        apply((AssignedMealPlan event)->{
            entryCard.mealPlanId = event.getMealPlanId();
        });

        apply((AssignedAccount event)->{
            entryCard.accountId = event.getAccountId();
        });
    }
}
