package com.guide.city.responses.entities;

import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 * User: dkovalskyi
 * Date: 19.10.13
 * Time: 20:25
 */
public class LocationCompletedResponse {
    @JsonView(Views.Public.class)
    private Integer locationId;

    public LocationCompletedResponse(){}

    public LocationCompletedResponse(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}
