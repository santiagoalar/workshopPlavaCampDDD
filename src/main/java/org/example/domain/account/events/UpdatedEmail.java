package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.Email;

public class UpdatedEmail extends DomainEvent {

    private final Email email;

    public UpdatedEmail(Email email) {
        super("plavaCamp.account.updatedEmail");
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }
}
