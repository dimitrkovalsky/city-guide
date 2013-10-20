package com.guide.city.beans;

import com.guide.city.beans.interfaces.IPlaceBean;
import com.guide.city.dao.PlaceDAO;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.exceptions.DAOException;
import com.guide.city.helpers.DAOFactory;
import com.guide.city.requests.GenericRequest;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;

import java.util.List;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 9:34 AM
 */
public class PlaceBean implements IPlaceBean {

    @Override
    public GenericResponse find(PlaceEntity place, GenericRequest request) throws ApplicationException {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        if (place == null || place.getId() == null || place.getId() == 0)
            throw new DAOException("Null place that find");

        PlaceEntity findingPlace = dao.find(place.getId());

        if (findingPlace == null)
            throw new DAOException("Null finding place");

        return ResponseFactory.createResponse(request).setResponse(findingPlace);
    }

    @Override
    public GenericResponse findAll(GenericRequest request) throws ApplicationException {
        PlaceDAO dao = DAOFactory.getPlaceDAO();
        List<PlaceEntity> findingPlaces = dao.findAll();

        if (findingPlaces == null)
            throw new DAOException("Null finding places");

        return ResponseFactory.createResponse(request).setResponse(findingPlaces);
    }
}
