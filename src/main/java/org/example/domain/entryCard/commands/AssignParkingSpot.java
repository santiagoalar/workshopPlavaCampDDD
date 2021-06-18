package org.example.domain.entryCard.commands;

import co.com.sofka.domain.generic.Command;
import org.example.domain.entryCard.values.EntryCardId;
import org.example.domain.entryCard.values.ParkingSpotId;

public class AssignParkingSpot implements Command {

    private final EntryCardId entryCardId;
    private final ParkingSpotId parkingSpotId;

    public AssignParkingSpot(EntryCardId entryCardId, ParkingSpotId parkingSpotId) {
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
