package org.example.domain.account.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Age implements ValueObject<String> {

    private final String value;

    public String value() {
        return value;
    }

    public Age(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Age cannot be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Age age = (Age) o;
        return Objects.equals(value, age.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
