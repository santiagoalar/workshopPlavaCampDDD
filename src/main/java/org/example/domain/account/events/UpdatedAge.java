package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.Age;

public class UpdatedAge extends DomainEvent {
    private final Age age;

    public UpdatedAge(Age age) {
        super("sofka.account.updatedAge");
        this.age = age;
    }

    public Age getAge() {
        return age;
    }
}
