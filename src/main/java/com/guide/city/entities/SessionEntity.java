package com.guide.city.entities;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.guide.city.helpers.Views;
import org.bson.types.ObjectId;
import org.codehaus.jackson.map.annotate.JsonView;

import java.util.Date;


@Entity(value = "sessions", noClassnameStored = true)
public class SessionEntity {

    @Id
    @JsonView(Views.Public.class)
    private ObjectId securityToken;

    @JsonView(Views.Public.class)
    private Date lastActivity;

    @JsonView(Views.Private.class)
    private String deviceId;

    public SessionEntity() {
        lastActivity = new Date();
    }

    public SessionEntity(String securityToken) {
        this.securityToken = new ObjectId(securityToken);
    }

    public SessionEntity(ObjectId securityToken) {
        this.securityToken = securityToken;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public ObjectId getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(ObjectId securityToken) {
        this.securityToken = securityToken;
    }

    @Override
    public String toString() {
        return "SessionEntity{" +
                "securityToken=" + securityToken +
                ", lastActivity=" + lastActivity +
                ", deviceId='" + deviceId + '\'' +
                '}';
    }
}
