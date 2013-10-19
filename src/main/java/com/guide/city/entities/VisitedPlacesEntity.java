package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

import java.util.ArrayList;
import java.util.List;

@Entity(value = "visited_places", noClassnameStored = true)
public class VisitedPlacesEntity {

    @Id
    @Indexed
    @JsonView(Views.Public.class)
    private String deviceId;
    @JsonView(Views.Public.class)
    private List<Integer> places;
    @JsonView(Views.Public.class)
    private List<Integer> streets;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<Integer> getPlaces() {
        if (places == null)
            places = new ArrayList<Integer>();
        return places;
    }

    public void setPlaces(List<Integer> places) {
        this.places = places;
    }

    public boolean checkVisitedPlace(Integer id) {
        return getPlaces().contains(id);
    }

    public void addVisitedPlace(Integer id) {
        if (places == null)
            places = new ArrayList<Integer>();
        places.add(id);
    }

    @Override
    public String toString() {
        return "VisitedPlacesEntity{" +
                "places=" + places +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }

    public List<Integer> getStreets() {
        if (streets == null)
            streets = new ArrayList<Integer>();
        return streets;
    }

    public void setStreets(List<Integer> streets) {
        this.streets = streets;
    }

    public void addVisitedStreet(Integer id) {
        if (streets == null)
            streets = new ArrayList<Integer>();
        streets.add(id);
    }

    public boolean checkVisitedStreet(Integer id) {
        return getStreets().contains(id);
    }
}
