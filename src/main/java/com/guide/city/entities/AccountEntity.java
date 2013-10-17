package com.guide.city.entities;


import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.guide.city.helpers.Views;
import org.bson.types.ObjectId;
import org.codehaus.jackson.map.annotate.JsonView;

@Entity(value = "accounts", noClassnameStored = true)
public class AccountEntity {

    @Id
    @JsonView(Views.Key.class)
    private ObjectId accountId;

    @JsonView(Views.Public.class)
    private String deviceId;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public ObjectId getAccountId() {
        return accountId;
    }

    public void setAccountId(ObjectId accountId) {
        this.accountId = accountId;
    }
}
