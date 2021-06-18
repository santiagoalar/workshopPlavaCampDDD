package org.example.domain.entryCard.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.ParkingSpotId;

public class AssignedParkingSpot extends DomainEvent {

    private final EntryCardId entryCardId;
    private final ParkingSpotId parkingSpotId;

    public AssignedParkingSpot(EntryCardId entryCardId, ParkingSpotId parkingSpotId) {
        super("plavaCamp.entryCard.assignedParkingSpot");
        this.entryCardId = entryCardId;
        this.parkingSpotId = parkingSpotId;
    }

    public EntryCardId getEntryCardId() {
        return entryCardId;
    }

    public ParkingSpotId getParkingSpotId() {
        return parkingSpotId;
    }
}
