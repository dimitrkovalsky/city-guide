package com.guide.city.entities;

import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

import java.util.Date;

/**
 * User: Dimitr
 * Date: 27.11.12
 * Time: 10:34
 */
@com.google.code.morphia.annotations.Entity(value = "sessions", noClassnameStored = true)
public class SessionEntity {

    /**
     * Security token
     */
    @JsonView(Views.Public.class)
    private String securityToken;

    /**
     * Last update time, uses for deleting objects from TTL collection
     */
    @JsonView(Views.Public.class)
    private Date lastActivity;
    /**
     * Account external id
     */
    @JsonView(Views.Private.class)
    private String externalId;

    /**
     * Account internal id
     */
    @JsonView(Views.Private.class)
    private String deviceId;

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

//    public BasicDBObject toBasicDBObject() {
//        BasicDBObject dbObject = new BasicDBObject();
//        Map<String, Object> fields = new HashMap<String, Object>();
//        fields.put("_id", securityToken);
//        fields.put("intId", internalId);
//        fields.put("extId", externalId);
//        if(ipAddress != null)
//            fields.put("ipAdd", ipAddress);
//        fields.put("lastActivity", lastActivity);
//        dbObject.putAll(fields);
//
//        return dbObject;
//    }
}
