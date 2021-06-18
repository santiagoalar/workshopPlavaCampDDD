package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.CottageId;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.QuantityBeds;

public class UpdatedQuantityBedsCottage extends DomainEvent {

    private final EntryCardId entryCardId;
    private final CottageId cottageId;
    private final QuantityBeds quantityBeds;

    public UpdatedQuantityBedsCottage(EntryCardId entryCardId, CottageId cottageId, QuantityBeds quantityBeds) {
        super("plavaCamp.entryCard.updateQuantityBedsCottage");
        this.entryCardId = entryCardId;
        this.cottageId = cottageId;
        this.quantityBeds = quantityBeds;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public CottageId getCottageId() {
        return cottageId;
    }

    public QuantityBeds getQuantityBeds() {
        return quantityBeds;
    }
}
