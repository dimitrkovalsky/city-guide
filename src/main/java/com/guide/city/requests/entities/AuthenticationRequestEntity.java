package com.guide.city.requests.entities;


import com.guide.city.annotations.NotNull;

public class AuthenticationRequestEntity {

    @NotNull
    private String deviceId;

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
}
