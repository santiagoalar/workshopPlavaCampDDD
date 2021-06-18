package org.example.domain.entryCard.values;

import co.com.sofka.domain.generic.ValueObject;

public class Coordinates implements ValueObject<Coordinates.Props> {

    private final String longitude;
    private final String latitude;

    public Coordinates(String longitude, String latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String Longitude() {
                return longitude;
            }

            @Override
            public String Latitude() {
                return latitude;
            }
        };
    }

    public interface Props {
        String Longitude();
        String Latitude();
    }
}
