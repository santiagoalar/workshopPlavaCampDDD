package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.BloodType;
import org.example.domain.account.values.GuestId;
import org.example.genericValues.Name;

public class GuestAdded extends DomainEvent {

    private final GuestId guestId;
    private final Name name;
    private final Age age;
    private final BloodType bloodType;

    public GuestAdded(GuestId guestId, Name name, Age age, BloodType bloodType) {
        super("plavaCamp.account.assignedGuest");
        this.guestId = guestId;
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
