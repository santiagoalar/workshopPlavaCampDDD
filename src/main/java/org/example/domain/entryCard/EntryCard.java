package org.example.domain.entryCard;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.events.CreatedEntryCard;
import org.example.domain.entryCard.values.*;

public class EntryCard extends AggregateEvent<EntryCardId> {

    protected ArrivalDate arrivalDate;
    protected DepartureDate departureDate;
    protected AccountId accountId;
    protected MealPlanId mealPlanId;
    protected CottageId cottageId;


    public EntryCard(EntryCardId entityId, AccountId accountId) {
        super(entityId);
        appendChange(new CreatedEntryCard(entityId, accountId)).apply();

    }
}
