package org.example.domain.account.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.domain.account.values.BraceletId;
import org.example.domain.account.values.Color;
import org.example.domain.account.values.Size;

public class BraceletAdded extends DomainEvent {

    private final BraceletId braceletId;
    private final Color color;
    private final Size size;

    public BraceletAdded(BraceletId braceletId, Color color, Size size) {
        super("plavaCamp.account.braceletAdded");
        this.braceletId = braceletId;
        this.color = color;
        this.size = size;
    }

    public BraceletId getBraceletId() {
        return braceletId;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }
}
