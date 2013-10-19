package com.guide.city.entities;

import com.google.code.morphia.annotations.*;
import com.google.code.morphia.utils.IndexDirection;
import com.guide.city.annotations.NotNull;
import com.guide.city.helpers.Views;
import com.guide.city.requests.entities.GeolocationRequestEntity;
import org.codehaus.jackson.map.annotate.JsonView;

import java.util.Date;

@Entity(value = "geolocations", noClassnameStored = true)
public class GeolocationEntity {
    @Id
    @JsonView(Views.Public.class)
    private String deviceId;

    @Embedded
    @Indexed(IndexDirection.GEO2D)
    @JsonView(Views.Public.class)
    private Location location;

    @JsonView(Views.Public.class)
    private Float accuracy;

    @JsonView(Views.Public.class)
    private Date timestamp;

    public GeolocationEntity() { }

    public GeolocationEntity(String deviceId, GeolocationRequestEntity request) {
        this.deviceId = deviceId;
        accuracy = request.getAccuracy();
        timestamp = new Date();
        location = new Location(request.getLatitude(), request.getLongitude());
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Float accuracy) {
        this.accuracy = accuracy;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "GeolocationEntity{" +
                "deviceId='" + deviceId + '\'' +
                ", location=" + location +
                ", accuracy=" + accuracy +
                ", timestamp=" + timestamp +
                '}';
    }


}
