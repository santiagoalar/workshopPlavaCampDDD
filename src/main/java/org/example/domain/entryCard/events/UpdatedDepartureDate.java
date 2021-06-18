package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.DepartureDate;
import org.example.domain.entryCard.values.EntryCardId;

public class UpdatedDepartureDate extends DomainEvent {

    private final EntryCardId entryCardId;
    private final DepartureDate departureDate;

    public UpdatedDepartureDate(EntryCardId entryCardId, DepartureDate departureDate) {
        super("plavaCamp.entryCard.updatedDepartureDate");
        this.entryCardId = entryCardId;
        this.departureDate = departureDate;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public DepartureDate getDepartureDate() {
        return departureDate;
    }
}
