package com.guide.city.beans.interfaces;

import com.guide.city.entities.SessionEntity;
import com.guide.city.requests.GenericRequest;
import com.guide.city.requests.entities.GeolocationRequestEntity;
import com.guide.city.responses.GenericResponse;

public interface IGeolocationBean {
    public GenericResponse locationChanged(GeolocationRequestEntity requestEntity, SessionEntity session, GenericRequest request);
}
