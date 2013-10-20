package com.guide.city.entities;

import java.util.Map;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 9:29
 */
public class LeaderboardEntity {
    private String deviceId;
    private Map<Integer, Integer> totalPoints;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Map<Integer, Integer> getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Map<Integer, Integer> totalPoints) {
        this.totalPoints = totalPoints;
    }
}
