package org.example.domain.account.values;

import co.com.sofka.domain.generic.Identity;

public class GuestId extends Identity {

    public GuestId() {
    }

    private GuestId(String id){
        super(id);
    }

    public static GuestId of(String id){
        return new GuestId(id);
    }
}
