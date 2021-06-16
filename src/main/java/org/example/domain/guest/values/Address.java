package org.example.domain.guest.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Address implements ValueObject<String> {

    private final String value;

    @Override
    public String value() {
        return null;
    }

    public Address(String value) throws IllegalAccessException {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalAccessException("Address cannot be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(value, address.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
