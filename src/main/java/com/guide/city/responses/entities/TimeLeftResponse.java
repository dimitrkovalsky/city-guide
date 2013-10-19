package com.guide.city.responses.entities;

import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 * User: dkovalskyi
 * Date: 19.10.13
 * Time: 20:30
 */
public class TimeLeftResponse {
    @JsonView(Views.Public.class)
    private Integer locationId;
    @JsonView(Views.Public.class)
    private Long timeLeft;

    public TimeLeftResponse() {}

    public TimeLeftResponse(Integer locationId, Long timeLeft) {
        this.locationId = locationId;
        this.timeLeft = timeLeft;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Long getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Long timeLeft) {
        this.timeLeft = timeLeft;
    }
}
