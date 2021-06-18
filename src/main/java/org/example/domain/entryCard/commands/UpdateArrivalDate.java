package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.ArrivalDate;
import org.example.domain.entryCard.values.DepartureDate;
import org.example.domain.entryCard.values.EntryCardId;

public class UpdateArrivalDate implements Command {

    private final EntryCardId entryCardId;
    private final ArrivalDate arrivalDate;

    public UpdateArrivalDate(EntryCardId entryCardId, ArrivalDate arrivalDate) {
        this.entryCardId = entryCardId;
        this.arrivalDate = arrivalDate;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public ArrivalDate getArrivalDate() {
        return arrivalDate;
    }

}
