package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.Age;
import org.example.genericValues.Name;

public class CreatedGuest extends DomainEvent {

    private final Name name;
    private final Age age;

    public CreatedGuest(Name name, Age age) {
        super("sofka.guest.createdGuest");
        this.name = name;
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }
}
