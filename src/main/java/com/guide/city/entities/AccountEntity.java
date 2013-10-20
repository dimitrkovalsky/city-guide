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
    @JsonView(Views.Public.class)
    private String googleId;
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String picture;
    @JsonView(Views.Public.class)
    private String sex;
    @JsonView(Views.Public.class)
    private String locale;

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

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
