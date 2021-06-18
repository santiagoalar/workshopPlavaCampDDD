package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class QuantityPeople implements ValueObject<String> {

    private final String value;

    public QuantityPeople(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Quantity of people cannot be ampty");
        }
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityPeople that = (QuantityPeople) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
