package com.guide.city.helpers;

import com.guide.city.beans.AuthenticationBean;
import com.guide.city.beans.GeolocationBean;

public class BeanFactory {
    public static AuthenticationBean getAuthenticationBean() {
        return new AuthenticationBean();
    }

    public static GeolocationBean getGeolocationBean() {
        return new GeolocationBean();
    }
}
