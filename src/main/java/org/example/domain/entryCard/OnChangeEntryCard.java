package org.example.domain.entryCard;

import co.com.sofka.domain.generic.EventChange;
import org.example.domain.entryCard.events.*;

import java.util.HashSet;
import java.util.Objects;

public class OnChangeEntryCard extends EventChange {

    public OnChangeEntryCard(EntryCard entryCard){
        apply((CreatedEntryCard event)->{
            entryCard.accountId = event.getAccountId();
            entryCard.parkingSpotIds = new HashSet<>();
        });

        apply((UpdatedArrivalDate event)->{
            if(Objects.isNull(entryCard.accountId)){
                throw new IllegalArgumentException("Arrival date cannot be assigned without account linked");
            }
            entryCard.arrivalDate = event.getArrivalDate();
        });

        apply((UpdatedDepartureDate event)->{
            if(Objects.isNull(entryCard.accountId)){
                throw new IllegalArgumentException("Departure date cannot be assigned without account linked");
            }
            entryCard.departureDate = event.getDepartureDate();
        });

        apply(((AssignedCottage event)->{
            entryCard.cottageId = event.getCottageId();
        }));

        apply((UpdatedQuantityBedsCottage event)->{
            entryCard.cottageId = event.getCottageId();
        });

        apply((AssignedMealPlan event)->{
            entryCard.mealPlanId = event.getMealPlanId();
        });

        apply((UpdatedQuantityPeopleMealPlan event)->{
            entryCard.mealPlanId = event.getMealPlanId();

            //Algo mas
        });

        apply((AssignedAccount event)->{
            entryCard.accountId = event.getAccountId();
        });

        apply((AssignedParkingSpot event)->{
            entryCard.parkingSpotIds.add(event.getParkingSpotId());
        });

    }
}
