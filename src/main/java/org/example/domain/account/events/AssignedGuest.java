package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.GuestId;

public class AssignedGuest extends DomainEvent {

    private final GuestId guestId;

    public AssignedGuest(GuestId guestId) {
        super("plavaCamp.account.assignedGuest");
        this.guestId = guestId;
    }

    public GuestId getGuestId() {
        return guestId;
    }
}
