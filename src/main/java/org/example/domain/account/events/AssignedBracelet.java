package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.BraceletId;

public class AssignedBracelet extends DomainEvent {

    private final BraceletId braceletId;

    public AssignedBracelet(BraceletId braceletId) {
        super("sofka.account.assignedBracelet");
        this.braceletId = braceletId;
    }

    public BraceletId getBraceletId() {
        return braceletId;
    }
}
