package org.example.domain.entryCard;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.entryCard.values.Coordinates;
import org.example.domain.entryCard.values.IsCovered;
import org.example.domain.entryCard.values.ParkingSpotId;

public class ParkingSpot extends Entity<ParkingSpotId> {

    private IsCovered isCovered;
    private Coordinates coordinates;

    public ParkingSpot(ParkingSpotId entityId, IsCovered isCovered, Coordinates coordinates) {
        super(entityId);
        this.isCovered = isCovered;
        this.coordinates = coordinates;
    }


    public void updateCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void updateIsCovered(IsCovered isCovered) {
        this.isCovered = isCovered;
    }

    public IsCovered getIsCovered() {
        return isCovered;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


}
