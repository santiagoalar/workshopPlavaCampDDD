package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.Identity;

public class EntryCardId extends Identity {

    public EntryCardId() {
    }

    private EntryCardId(String id){
        super(id);
    }

    public static EntryCardId of(String id){
        return new EntryCardId(id);
    }
}
