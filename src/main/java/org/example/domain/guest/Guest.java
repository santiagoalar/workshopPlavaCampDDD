package org.example.domain.guest;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.domain.guest.values.Age;
import org.example.domain.guest.values.GuestId;
import org.example.genericValues.Name;

public class Guest extends AggregateEvent<GuestId> {
    public Guest(GuestId entityId, Name name, Age age) {
        super(entityId);
    }
}
