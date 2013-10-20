package com.guide.city.requests.entities;


import com.guide.city.annotations.NotNull;

public class AuthenticationRequestEntity {

    @NotNull
    private String deviceId;
    @NotNull
    private String googleId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String toString() {
        return "AuthenticationRequestEntity{" +
                "deviceId='" + deviceId + '\'' +
                '}';
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }
}
