package com.guide.city.entities;


import com.google.code.morphia.annotations.Embedded;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

@Embedded
public class Location {

    @JsonView(Views.Public.class)
    private Double latitude;
    @JsonView(Views.Public.class)
    private Double longitude;

    public Location() {}

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public String toGoogleStringFormat() {
        return getLatitude().toString() + "," + getLongitude().toString();
    }
}
