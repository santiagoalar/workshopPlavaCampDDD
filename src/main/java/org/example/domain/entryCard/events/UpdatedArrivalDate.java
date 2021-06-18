package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.ArrivalDate;
import org.example.domain.entryCard.values.EntryCardId;

public class UpdatedArrivalDate extends DomainEvent {

    private final EntryCardId entryCardId;
    private final ArrivalDate arrivalDate;

    public UpdatedArrivalDate(EntryCardId entryCardId, ArrivalDate arrivalDate) {
        super("plavaCamp.entryCard.updatedArrivalDate");
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
