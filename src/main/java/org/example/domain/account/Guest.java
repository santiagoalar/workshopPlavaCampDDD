package org.example.domain.account;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.account.values.Age;
import org.example.domain.account.values.BloodType;
import org.example.domain.account.values.GuestId;
import org.example.genericValues.Name;

public class Guest extends Entity<GuestId> {

    private Name name;
    private Age age;
    private BloodType bloodType;

    public Guest(GuestId entityId, Name name, Age age, BloodType bloodType) {
        super(entityId);
        this.name = name;
        this.age = age;
        this.bloodType = bloodType;
    }

    public void updateName(Name name){
        this.name = name;
    }

    public void updateAge(Age age){
        this.age = age;
    }

    public void updateBloodyType(BloodType bloodType){
        this.bloodType = bloodType;
    }

    public Name name() {
        return name;
    }

    public Age age() {
        return age;
    }

    public BloodType bloodType() {
        return bloodType;
    }
}
