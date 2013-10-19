package com.guide.city.beans;


import com.guide.city.beans.interfaces.IGeolocationBean;
import com.guide.city.dao.*;
import com.guide.city.entities.*;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.exceptions.DAOException;
import com.guide.city.helpers.DAOFactory;
import com.guide.city.requests.GenericRequest;
import com.guide.city.requests.entities.GeolocationRequestEntity;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;
import com.guide.city.responses.entities.LocationCompletedResponse;
import com.guide.city.responses.entities.PlaceFoundResponse;
import com.guide.city.responses.entities.TimeLeftResponse;
import com.guide.city.types.ResponseType;

public class GeolocationBean implements IGeolocationBean {

    @Override
    public GenericResponse locationChanged(GeolocationRequestEntity requestEntity, SessionEntity session,
            GenericRequest request) throws ApplicationException {
        GeolocationDAO geolocationDAO = DAOFactory.getGeolocationDAO();
        GeolocationEntity geolocationEntity = new GeolocationEntity(session.getDeviceId(), requestEntity);
        geolocationDAO.save(geolocationEntity);

        //GenericResponse response = ResponseFactory.createResponse(request);
        GenericResponse result = checkPlaceFound(geolocationEntity, request);
        if (result != null)
            return result;
        result = checkInterestingInformation(geolocationEntity, request);
        if (result != null)
            return result;
        return ResponseFactory.createResponse(request);
    }

    @Override
    public GenericResponse locationCompleted(SessionEntity session, GenericRequest request)
            throws ApplicationException {
        LocationTimerDAO locationTimerDAO = DAOFactory.getLocationTimerDAO();
        LocationTimerEntity timerEntity = locationTimerDAO.findByDeviceId(session.getDeviceId());
        long diff = (System.currentTimeMillis() - timerEntity.getStarted()) / 1000;
        if (diff < 30) {
            GenericResponse result = ResponseFactory.createResponse(request, ResponseType.TIME_LEFT);
            result.setResponse(new TimeLeftResponse(timerEntity.getLocationId(), 30 - diff));
            return result;
        }
        else {
            VisitedPlacesDAO visitedPlacesDAO = DAOFactory.getVisitedPlacesDAO();
            VisitedPlacesEntity visitedPlacesEntity = visitedPlacesDAO.findByDeviceId(session.getDeviceId());
            visitedPlacesEntity.addVisitedPlace(timerEntity.getLocationId());
            visitedPlacesDAO.save(visitedPlacesEntity);
            GenericResponse result = ResponseFactory.createResponse(request, ResponseType.LOCATION_COMPLETED);
            result.setResponse(new LocationCompletedResponse(timerEntity.getLocationId()));
            return result;
        }
    }

    private GenericResponse checkPlaceFound(GeolocationEntity geolocationEntity, GenericRequest request)
            throws DAOException {

        VisitedPlacesDAO visitedPlacesDAO = DAOFactory.getVisitedPlacesDAO();
        PlaceDAO placeDAO = DAOFactory.getPlaceDAO();
        PlaceEntity placeEntity = placeDAO.findNear(geolocationEntity.getLocation());
        if (placeEntity == null)
            return null;

        VisitedPlacesEntity visitedPlacesEntity = visitedPlacesDAO.findByDeviceId(geolocationEntity.getDeviceId());
        if (visitedPlacesEntity.checkVisitedPlace(placeEntity.getId()))
            return null;
        LocationTimerDAO locationTimerDAO = DAOFactory.getLocationTimerDAO();
        LocationTimerEntity timerEntity = new LocationTimerEntity();
        timerEntity.setStarted(System.currentTimeMillis());
        timerEntity.setDeviceId(geolocationEntity.getDeviceId());
        timerEntity.setLocationId(placeEntity.getId());
        timerEntity.setTimeLeft(30);
        locationTimerDAO.save(timerEntity);
        GenericResponse result = ResponseFactory.createResponse(request, ResponseType.PLACE_FOUND);
        result.setResponse(new PlaceFoundResponse(placeEntity, timerEntity));
        return result;
    }

    private GenericResponse checkInterestingInformation(GeolocationEntity geolocationEntity, GenericRequest request)
            throws DAOException {
        VisitedPlacesDAO visitedPlacesDAO = DAOFactory.getVisitedPlacesDAO();
        StreetDAO streetDAO = DAOFactory.getStreetDAO();
        StreetEntity streetEntity = streetDAO.findNear(geolocationEntity.getLocation());
        if (streetEntity == null)
            return null;
        VisitedPlacesEntity visitedPlacesEntity = visitedPlacesDAO.findByDeviceId(geolocationEntity.getDeviceId());
        if (visitedPlacesEntity.checkVisitedStreet(streetEntity.getId()))
            return null;
        visitedPlacesEntity.addVisitedStreet(streetEntity.getId());
        visitedPlacesDAO.save(visitedPlacesEntity);

        GenericResponse result = ResponseFactory.createResponse(request, ResponseType.INTERESTING_INFORMATION);
        result.setResponse(streetEntity);
        return result;
    }


}
