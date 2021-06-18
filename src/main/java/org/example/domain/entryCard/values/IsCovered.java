package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsCovered implements ValueObject<String> {

    private final String value;

    public IsCovered(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("IsCovered cannot be empty");
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
        IsCovered isCovered = (IsCovered) o;
        return Objects.equals(value, isCovered.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
