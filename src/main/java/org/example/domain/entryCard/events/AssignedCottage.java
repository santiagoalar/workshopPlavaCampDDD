package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.CottageId;
import org.example.domain.entryCard.values.EntryCardId;

public class AssignedCottage extends DomainEvent {

    private final EntryCardId entryCardId;
    private final CottageId cottageId;

    public AssignedCottage(EntryCardId entryCardId, CottageId cottageId) {
        super("plavaCamp.entryCard.assignedCottage");
        this.entryCardId = entryCardId;
        this.cottageId = cottageId;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public CottageId getCottageId() {
        return cottageId;
    }

}
