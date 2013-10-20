package com.guide.city.beans.interfaces;

import com.guide.city.entities.PlaceEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.requests.GenericRequest;
import com.guide.city.responses.GenericResponse;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 9:29 AM
 */
public interface IPlaceBean {

    public GenericResponse findAll(GenericRequest request) throws ApplicationException;

    public GenericResponse find(PlaceEntity place, GenericRequest request) throws ApplicationException;
}
