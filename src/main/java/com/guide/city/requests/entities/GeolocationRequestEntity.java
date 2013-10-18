package com.guide.city.requests.entities;


import com.guide.city.annotations.NotNull;

public class GeolocationRequestEntity {
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    private Float Accuracy;

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

    public Float getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(Float accuracy) {
        Accuracy = accuracy;
    }
}
