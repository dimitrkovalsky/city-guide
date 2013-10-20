package com.guide.city.helpers;

import com.guide.city.beans.AuthenticationBean;
import com.guide.city.beans.GeolocationBean;
import com.guide.city.beans.PlaceBean;
import com.guide.city.beans.StreetBean;

public class BeanFactory {
    public static AuthenticationBean getAuthenticationBean() {
        return new AuthenticationBean();
    }

    public static GeolocationBean getGeolocationBean() {
        return new GeolocationBean();
    }

    public static PlaceBean getPlaceBean() {
        return new PlaceBean();
    }

    public static StreetBean getStreetBean() {
        return new StreetBean();
    }
}
