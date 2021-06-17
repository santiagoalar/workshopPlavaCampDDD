package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.BloodType;
import org.example.domain.account.values.GuestId;

public class UpdatedBloodTypeGuest extends DomainEvent {
    private final GuestId guestId;
    private final BloodType bloodType;

    public UpdatedBloodTypeGuest(GuestId guestId, BloodType bloodType) {
        super("plavaCamp.account.updatedBloodTypeAccount");
        this.guestId = guestId;
        this.bloodType = bloodType;
    }

    public GuestId getGuestId() {
        return guestId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }
}
