package com.guide.city.responses.entities;

import com.guide.city.helpers.Views;
import org.codehaus.jackson.map.annotate.JsonView;

public class AuthenticationResponse {

    @JsonView(Views.Public.class)
    private String securityToken;

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }
}
