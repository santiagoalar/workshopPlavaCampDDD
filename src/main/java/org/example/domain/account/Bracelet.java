package org.example.domain.account.values;

import co.com.sofka.domain.generic.Entity;

public class Bracelet extends Entity<BraceletId> {

    private Color color;
    private Size size;

    public Bracelet(BraceletId entityId, Color color, Size size) {
        super(entityId);
        this.color = color;
        this.size = size;
    }

    public void updateColor(Color color){
        this.color = color;
    }

    public void updateSize(Size size){
        this.size = size;
    }

    public Color color() {
        return color;
    }

    public Size size() {
        return size;
    }
}
