package org.example.domain.account.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Address implements ValueObject<String> {

    private final String value;

    @Override
    public String value() {
        return value;
    }

    public Address(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Address cannot be empty");
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
