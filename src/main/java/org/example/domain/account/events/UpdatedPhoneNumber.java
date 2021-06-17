package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.PhoneNumber;

public class UpdatedPhoneNumber extends DomainEvent {

    private final PhoneNumber phoneNumber;

    public UpdatedPhoneNumber(PhoneNumber phoneNumber) {
        super("plavaCamp.account.updatedPhoneNumber");
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
