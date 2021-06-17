package org.example.domain.account.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class BloodType implements ValueObject<String> {

    private final String value;

    public BloodType(String value) {
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Blood type cannot be empty");
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
        BloodType bloodType = (BloodType) o;
        return Objects.equals(value, bloodType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
