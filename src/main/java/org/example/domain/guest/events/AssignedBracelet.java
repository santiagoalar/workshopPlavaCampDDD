package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.BraceletId;

public class AssignedBracelet extends DomainEvent {

    private final BraceletId braceletId;

    public AssignedBracelet(BraceletId braceletId) {
        super("sofka.guest.assignedBracelet");
        this.braceletId = braceletId;
    }

    public BraceletId getBraceletId() {
        return braceletId;
    }
}
