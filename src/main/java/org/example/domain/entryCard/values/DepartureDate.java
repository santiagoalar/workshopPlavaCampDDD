package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DepartureDate implements ValueObject<String> {

    private final String value;

    public DepartureDate(String value) {
        this.value = Objects.requireNonNull(value);
        if (value.isBlank()){
            throw new IllegalArgumentException("Departure cannot be empty");
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
        DepartureDate that = (DepartureDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
