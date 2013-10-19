package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

@Entity(value = "places", noClassnameStored = true)
public class PlaceEntity {

    @Id
    @JsonView(Views.Key.class)
    private Integer id;

    @JsonView(Views.Public.class)
    private Location geometry;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String formattedAddress;

    @JsonView(Views.Public.class)
    private String types;

    @JsonView(Views.Public.class)
    private String information;

    public PlaceEntity(){}

    public PlaceEntity(Integer id) {
        setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getGeometry() {
        return geometry;
    }

    public void setGeometry(Location geometry) {
        this.geometry = geometry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", geometry=" + geometry +
                ", name='" + name + '\'' +
                ", formattedAddress='" + formattedAddress + '\'' +
                ", types='" + types + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}