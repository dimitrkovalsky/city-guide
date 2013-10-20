package com.guide.city.beans.interfaces;

import com.guide.city.entities.StreetEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.requests.GenericRequest;
import com.guide.city.responses.GenericResponse;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 9:33 AM
 */
public interface IStreetBean {

    public GenericResponse find(StreetEntity street, GenericRequest request) throws ApplicationException;

    public GenericResponse findAll(GenericRequest request) throws ApplicationException;
}
