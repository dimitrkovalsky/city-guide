package com.guide.city.entities;

import com.guide.city.types.GameStatus;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 9:29
 */
public class LeaderboardEntity implements Comparable<LeaderboardEntity> {
    private String name;
    private Integer totalPoints;

    public LeaderboardEntity() {}

    public LeaderboardEntity(VisitedPlacesEntity visitedPlaces, String name) {
        this.name = name;
        if (visitedPlaces.getStatus().equals(GameStatus.COMPLETED)) {
            totalPoints = visitedPlaces.getLastPoints();
        }
        else {
            totalPoints = visitedPlaces.getPlaces().size();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public int compareTo(LeaderboardEntity o) {
        return totalPoints.compareTo(o.getTotalPoints());
    }
}
