package org.example.domain.account.values;

import co.com.sofka.domain.generic.Identity;

public class BraceletId extends Identity {

    public BraceletId() {
    }

    private BraceletId(String id){
        super(id);
    }

    public static BraceletId of(String id){
        return new BraceletId(id);
    }
}
