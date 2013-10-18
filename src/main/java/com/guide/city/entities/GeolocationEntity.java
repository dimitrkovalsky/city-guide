package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.guide.city.annotations.NotNull;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

@Entity(value = "geolocations", noClassnameStored = true)
public class GeolocationEntity {
    @Id
    @JsonView(Views.Public.class)
    private String deviceId;

    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;

    private Float Accuracy;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public Float getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(Float accuracy) {
        Accuracy = accuracy;
    }
}
