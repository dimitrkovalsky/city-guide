package com.guide.city.beans;


import com.guide.city.beans.interfaces.IGeolocationBean;
import com.guide.city.dao.GeolocationDAO;
import com.guide.city.entities.GeolocationEntity;
import com.guide.city.entities.SessionEntity;
import com.guide.city.helpers.DAOFactory;
import com.guide.city.requests.GenericRequest;
import com.guide.city.requests.entities.GeolocationRequestEntity;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;

public class GeolocationBean implements IGeolocationBean {

    @Override
    public GenericResponse locationChanged(GeolocationRequestEntity requestEntity, SessionEntity session,
            GenericRequest request) {
        GeolocationDAO geolocationDAO = DAOFactory.getGeolocationDAO();
        GeolocationEntity geolocationEntity = new GeolocationEntity(session.getDeviceId(), requestEntity);
        geolocationDAO.save(geolocationEntity);

        //GenericResponse response = ResponseFactory.createResponse(request);
        GenericResponse result = checkPlaceFound(geolocationEntity);
        if (result != null)
            return result;
        result = checkInterestingInformation(geolocationEntity);
        if (result != null)
            return result;
        return ResponseFactory.createResponse(request);
    }

    private GenericResponse checkPlaceFound(GeolocationEntity geolocationEntity) {
        // Check visited
        // run timer
        return null;
    }

    private GenericResponse checkInterestingInformation(GeolocationEntity geolocationEntity) {
        return null;
    }


}
