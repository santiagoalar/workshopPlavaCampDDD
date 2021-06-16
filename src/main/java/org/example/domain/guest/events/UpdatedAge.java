package org.example.domain.guest.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.guest.values.Age;

public class UpdatedAge extends DomainEvent {
    private final Age age;

    public UpdatedAge(Age age) {
        super("sofka.guest.updatedAge");
        this.age = age;
    }

    public Age getAge() {
        return age;
    }
}
