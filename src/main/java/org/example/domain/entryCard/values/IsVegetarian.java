package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsVegetarian implements ValueObject<String> {

    private final String value;

    public IsVegetarian(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("IsVegetarian cannot be empty");
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
        IsVegetarian that = (IsVegetarian) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
