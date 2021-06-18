package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.Entity;
import org.example.domain.account.values.BraceletId;

public class Cottage extends Entity<BraceletId> {

    private QuantityBeds quantityBeds;
    private QuantityRooms quantityRooms;
    private QuantityBathrooms quantityBathrooms;

    public Cottage(BraceletId entityId, QuantityBeds quantityBeds, QuantityRooms quantityRooms, QuantityBathrooms quantityBathrooms) {
        super(entityId);
        this.quantityBeds = quantityBeds;
        this.quantityRooms = quantityRooms;
        this.quantityBathrooms = quantityBathrooms;
    }

    public void updateQuantityBeds(QuantityBeds quantityBeds){
        this.quantityBeds = quantityBeds;
    }

    public void updateQuantityRooms(QuantityRooms quantityRooms){
        this.quantityRooms = quantityRooms;
    }

    public void updateQuantityBathrooms(QuantityBathrooms quantityBathrooms){
        this.quantityBathrooms = quantityBathrooms;
    }

    public QuantityBeds getQuantityBeds() {
        return quantityBeds;
    }

    public QuantityRooms getQuantityRooms() {
        return quantityRooms;
    }

    public QuantityBathrooms getQuantityBathrooms() {
        return quantityBathrooms;
    }
}
