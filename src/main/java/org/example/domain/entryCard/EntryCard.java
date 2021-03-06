package org.example.domain.entryCard;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.events.*;
import org.example.domain.entryCard.values.*;

import java.util.List;
import java.util.Set;

public class EntryCard extends AggregateEvent<EntryCardId> {

    protected ArrivalDate arrivalDate;
    protected DepartureDate departureDate;
    protected AccountId accountId;
    protected MealPlanId mealPlanId;
    protected CottageId cottageId;
    protected Set<ParkingSpotId> parkingSpotIds;

    public EntryCard(EntryCardId entityId, AccountId accountId) {
        super(entityId);
        appendChange(new CreatedEntryCard(entityId, accountId)).apply();
    }

    private EntryCard(EntryCardId entryCardId){
        super(entryCardId);
        subscribe(new OnChangeEntryCard(this));
    }

    public static EntryCard from(EntryCardId entryCardId, List<DomainEvent> events){
        var entryCard = new EntryCard(entryCardId);
        events.forEach(entryCard::applyEvent);
        return entryCard;
    }

    public void updateArrivalDate(EntryCardId entryCardId, ArrivalDate arrivalDate){
        appendChange(new UpdatedArrivalDate(entryCardId, arrivalDate));
    }

    public void updateDeparture(EntryCardId entryCardId, DepartureDate departureDate){
        appendChange(new UpdatedDepartureDate(entryCardId, departureDate));
    }

    public void assignAccount(EntryCardId entryCardId, AccountId accountId){
        appendChange(new AssignedAccount(entryCardId, accountId));
    }

    public void assignCottage(EntryCardId entryCardId, CottageId cottageId){
        appendChange(new AssignedCottage(entryCardId, cottageId));
    }

    public void updateQuantityBedsCottage(EntryCardId entryCardId, CottageId cottageId, QuantityBeds quantityBeds){
        appendChange(new UpdatedQuantityBedsCottage(entryCardId, cottageId, quantityBeds));
    }

    public void assignMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, IsVegetarian isVegetarian, QuantityPeople quantityPeople){
        appendChange(new AssignedMealPlan(entryCardId, mealPlanId, isVegetarian, quantityPeople));
    }

    public void updateQuantityPeopleMealPlan(EntryCardId entryCardId, MealPlanId mealPlanId, QuantityPeople quantityPeople){
        appendChange(new UpdatedQuantityPeopleMealPlan(entryCardId, mealPlanId, quantityPeople));
    }

    public void assignParkingSpot(EntryCardId entryCardId, ParkingSpotId parkingSpotId){
        appendChange(new AssignedParkingSpot(entryCardId, parkingSpotId));
    }

    public ArrivalDate getArrivalDate() {
        return arrivalDate;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public MealPlanId getMealPlanId() {
        return mealPlanId;
    }

    public CottageId getCottageId() {
        return cottageId;
    }

    public Set<ParkingSpotId> getParkingSpotIds() {
        return parkingSpotIds;
    }
}
