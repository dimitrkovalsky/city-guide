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
    private List<VisitedEmbedded> places;
    @JsonView(Views.Public.class)
    private List<Integer> streets;
    @JsonView(Views.Public.class)
    private Integer status;
    @JsonView(Views.Public.class)
    private Integer lastPoints;

    @JsonView(Views.Public.class)
    private Long time;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public List<VisitedEmbedded> getPlaces() {
        if (places == null)
            places = new ArrayList<VisitedEmbedded>();
        return places;
    }

    public void setPlaces(List<VisitedEmbedded> places) {
        this.places = places;
    }

    public boolean checkVisitedPlace(Integer id) {
        return getPlaces().contains(new VisitedEmbedded(id));
    }

    public void addVisitedPlace(VisitedEmbedded place) {
        if (places == null)
            places = new ArrayList<VisitedEmbedded>();
        if (!places.contains(place))
            places.add(place);
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
        if (!streets.contains(id))
            streets.add(id);
    }

    public boolean checkVisitedStreet(Integer id) {
        return getStreets().contains(id);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLastPoints() {
        return lastPoints;
    }

    public void setLastPoints(Integer lastPoints) {
        this.lastPoints = lastPoints;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
