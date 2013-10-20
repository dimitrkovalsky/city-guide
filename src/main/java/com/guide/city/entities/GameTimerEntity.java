package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 9:08
 */
@Entity(value = "game_timer", noClassnameStored = true)
public class GameTimerEntity {
    @Id
    @Indexed
    @JsonView(Views.Private.class)
    private String deviceId;
    @JsonView(Views.Public.class)
    private Long started;
    @JsonView(Views.Public.class)
    private Integer timeLeft;

    public GameTimerEntity() {}

    public GameTimerEntity(String deviceId, Long started) {
        this.deviceId = deviceId;
        this.started = started;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getStarted() {
        return started;
    }

    public void setStarted(Long started) {
        this.started = started;
    }

    public Integer getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(Integer timeLeft) {
        this.timeLeft = timeLeft;
    }
}
