package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.CottageId;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.QuantityBeds;

public class UpdateQuantityBedsCottage implements Command {

    private final EntryCardId entryCardId;
    private final CottageId cottageId;
    private final QuantityBeds quantityBeds;

    public UpdateQuantityBedsCottage(EntryCardId entryCardId, CottageId cottageId, QuantityBeds quantityBeds) {
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
