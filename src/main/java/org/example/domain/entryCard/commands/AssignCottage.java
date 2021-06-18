package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.CottageId;
import org.example.domain.entryCard.values.EntryCardId;

public class AssignCottage implements Command {

    private final EntryCardId entryCardId;
    private final CottageId cottageId;

    public AssignCottage(EntryCardId entryCardId, CottageId cottageId) {
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
