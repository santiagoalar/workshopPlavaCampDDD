package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.values.ArrivalDate;
import org.example.domain.entryCard.values.DepartureDate;
import org.example.domain.entryCard.values.EntryCardId;

public class CreatedEntryCard extends DomainEvent {

    private final EntryCardId entryCardId;
    private final AccountId accountId;
    //private final ArrivalDate arrivalDate;
    //private final DepartureDate departureDate;

    //public CreatedEntryCard(EntryCardId entryCardId, ArrivalDate arrivalDate, DepartureDate departureDate) {
    public CreatedEntryCard(EntryCardId entryCardId, AccountId AccountId) {
        super("plavaCamp.entryCard.createdEntryCard");
        //this.arrivalDate = arrivalDate;
        //this.departureDate = departureDate;
        this.entryCardId = entryCardId;
        this.accountId = AccountId;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    /*public ArrivalDate getArrivalDate() {
        return arrivalDate;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }*/
}
