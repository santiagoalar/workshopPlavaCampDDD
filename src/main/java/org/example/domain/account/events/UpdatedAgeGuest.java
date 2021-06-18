package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.GuestId;

public class UpdatedAgeGuest extends DomainEvent {
    private final GuestId guestId;
    private final Age age;

    public UpdatedAgeGuest(GuestId guestId, Age age) {
        super("plavaCamp.account.updatedAgeGuest");
        this.guestId = guestId;
        this.age = age;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public Age getAge() {
        return age;
    }
}
