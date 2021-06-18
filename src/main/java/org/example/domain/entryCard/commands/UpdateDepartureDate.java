package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.DepartureDate;
import org.example.domain.entryCard.values.EntryCardId;

public class UpdateDepartureDate implements Command {

    private final EntryCardId entryCardId;
    private final DepartureDate departureDate;

    public UpdateDepartureDate(EntryCardId entryCardId, DepartureDate departureDate) {
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
