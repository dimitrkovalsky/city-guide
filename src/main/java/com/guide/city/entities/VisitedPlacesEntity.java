package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

import java.util.List;

@Entity(value = "visited_places", noClassnameStored = true)
public class VisitedPlacesEntity {

    @Id @Indexed
    @JsonView(Views.Public.class)
    private String deviceId;

    @JsonView(Views.Public.class)
    private List<Integer> places;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<Integer> getPlaces() {
        return places;
    }

    public void setPlaces(List<Integer> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "VisitedPlacesEntity{" +
                "places=" + places +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
