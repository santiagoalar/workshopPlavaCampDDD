package org.example.domain.account.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PhoneNumber implements ValueObject<String> {

    private final String value;

    public PhoneNumber(String value){
        this.value = Objects.requireNonNull(value);
        if(value.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be empty");
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
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
