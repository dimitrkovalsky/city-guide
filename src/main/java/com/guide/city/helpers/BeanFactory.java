package com.guide.city.helpers;

import com.guide.city.beans.AuthenticationBean;

public class BeanFactory {
    public static AuthenticationBean getAuthenticationBean() {
        return new AuthenticationBean();
    }
}
