package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.genericValues.Name;

public class UpdatedName extends DomainEvent {

    public final Name name;

    public UpdatedName(Name name) {
        super("sofka.guest.updatedName");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
