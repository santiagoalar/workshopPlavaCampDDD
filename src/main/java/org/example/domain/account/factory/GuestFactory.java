package org.example.domain.account.factory;

import org.example.domain.account.values.*;
import org.example.genericValues.Name;

import java.util.HashSet;
import java.util.Set;

public class GuestFactory {

    private Set<Guest> guestSet;

    private GuestFactory(){
        guestSet = new HashSet<>();
    }

    public static GuestFactory builder(){
        return new GuestFactory();
    }

    public GuestFactory newGuest(GuestId guestId, Name name, Age age, BloodType bloodType){
        guestSet.add(new Guest(guestId, name, age, bloodType));
        return this;
    }

    public Set<Guest> guests(){
        return guestSet;
    }
}
