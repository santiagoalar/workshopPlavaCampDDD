package org.example.domain.guest.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Age implements ValueObject<String> {

    private final String value;

    public Age(String value) throws IllegalAccessException {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalAccessException("Age cannot be empty");
        }
    }

    @Override
    public String value() {
        return null;
    }
}
