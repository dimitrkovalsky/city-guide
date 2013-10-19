package com.guide.city.responses.entities;

import com.guide.city.entities.LocationTimerEntity;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 * User: dkovalskyi
 * Date: 19.10.13
 * Time: 19:10
 */
public class PlaceFoundResponse {
    @JsonView(Views.Public.class)
    private PlaceEntity place;
    @JsonView(Views.Public.class)
    private LocationTimerEntity timer;


    public PlaceFoundResponse(PlaceEntity place, LocationTimerEntity timer) {
        this.place = place;
        this.timer = timer;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public LocationTimerEntity getTimer() {
        return timer;
    }

    public void setTimer(LocationTimerEntity timer) {
        this.timer = timer;
    }
}
