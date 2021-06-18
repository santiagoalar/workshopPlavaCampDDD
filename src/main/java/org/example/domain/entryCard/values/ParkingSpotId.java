package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.Identity;

public class ParkingSpotId extends Identity {
    public ParkingSpotId() {
    }

    private ParkingSpotId(String id){
        super(id);
    }

    public static ParkingSpotId of(String id){
        return new ParkingSpotId(id);
    }
}
