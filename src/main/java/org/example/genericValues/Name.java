package org.example.genericValues;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public String value() {
        return value;
    }

    public Name(String value) throws IllegalAccessException {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalAccessException("Name cannot be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
