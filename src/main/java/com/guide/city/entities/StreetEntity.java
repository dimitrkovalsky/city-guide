package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 * User: mkontarev
 * Date: 10/19/13
 * Time: 7:22 PM
 */
@Entity(value = "streets", noClassnameStored = true)
public class StreetEntity {

    @Id
    @JsonView(Views.Key.class)
    private Integer id;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String formattedAddress;

    @JsonView(Views.Public.class)
    private String information;

    public StreetEntity(){}

    public StreetEntity(Integer id){
        setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
