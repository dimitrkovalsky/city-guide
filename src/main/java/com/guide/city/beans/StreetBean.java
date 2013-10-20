package com.guide.city.beans;

import com.guide.city.beans.interfaces.IStreetBean;
import com.guide.city.dao.StreetDAO;
import com.guide.city.entities.StreetEntity;
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
 * Time: 9:46 AM
 */
public class StreetBean implements IStreetBean {

    @Override
    public GenericResponse find(StreetEntity street, GenericRequest request) throws ApplicationException {
        StreetDAO dao = DAOFactory.getStreetDAO();
        if (street == null || street.getId() == null || street.getId() == 0)
            throw new DAOException("Null street that find");

        StreetEntity findingStreet = dao.find(street.getId());

        if (findingStreet == null)
            throw new DAOException("Null finding street");

        return ResponseFactory.createResponse(request).setResponse(findingStreet);
    }

    @Override
    public GenericResponse findAll(GenericRequest request) throws ApplicationException {
        StreetDAO dao = DAOFactory.getStreetDAO();
        List<StreetEntity> findingStreets = dao.findAll();

        if (findingStreets == null)
            throw new DAOException("Null finding streets");

        return ResponseFactory.createResponse(request).setResponse(findingStreets);
    }
}
