package org.example.domain.guest.values;

import co.com.sofka.domain.generic.Identity;

public class HealthCareId extends Identity {

    public HealthCareId() {
    }

    private HealthCareId(String id){
        super(id);
    }

    public static HealthCareId of(String id){
        return new HealthCareId(id);
    }
}
