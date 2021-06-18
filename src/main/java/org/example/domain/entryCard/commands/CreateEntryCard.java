package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.account.values.AccountId;
import org.example.domain.entryCard.values.ArrivalDate;
import org.example.domain.entryCard.values.DepartureDate;
import org.example.domain.entryCard.values.EntryCardId;

public class CreateEntryCard implements Command {

    private final EntryCardId entryCardId;
    private final AccountId accountId;
    /*private final ArrivalDate arrivalDate;
    private final DepartureDate departureDate;*/

    //public CreateEntryCard(EntryCardId entryCardId, ArrivalDate arrivalDate, DepartureDate departureDate) {
    public CreateEntryCard(EntryCardId entryCardId, AccountId accountId) {
        this.entryCardId = entryCardId;
        this.accountId = accountId;
        /*this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;*/
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
