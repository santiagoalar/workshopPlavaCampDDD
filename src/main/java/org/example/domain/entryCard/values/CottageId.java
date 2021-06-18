package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.Identity;

public class CottageId extends Identity {

    public CottageId() {
    }

    private CottageId(String id){
        super(id);
    }

    public static CottageId of(String id){
        return new CottageId(id);
    }
}
