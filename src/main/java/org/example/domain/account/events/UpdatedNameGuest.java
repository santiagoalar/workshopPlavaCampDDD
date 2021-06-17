package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.GuestId;
import org.example.genericValues.Name;

public class UpdatedNameGuest extends DomainEvent {

    private final GuestId guestId;
    private final Name name;

    public UpdatedNameGuest(GuestId guestId, Name name) {
        super("plavaCamp.guest.updatedNameAccount");
        this.guestId = guestId;
        this.name = name;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public Name getName() {
        return name;
    }
}
