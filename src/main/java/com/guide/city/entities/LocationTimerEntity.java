package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

@Entity(value = "location_timer", noClassnameStored = true)
public class LocationTimerEntity {

    @Indexed
    @JsonView(Views.Public.class)
    private String deviceId;

    @Indexed
    @JsonView(Views.Public.class)
    private Integer locationId;

    @JsonView(Views.Public.class)
    private Long started;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Long getStarted() {
        return started;
    }

    public void setStarted(Long started) {
        this.started = started;
    }
}
