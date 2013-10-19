package com.guide.city.commands;

import com.guide.city.annotations.Input;
import com.guide.city.annotations.Validatable;
import com.guide.city.beans.interfaces.IGeolocationBean;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.requests.entities.GeolocationRequestEntity;
import com.guide.city.responses.GenericResponse;

@Validatable
public class LocationChangedCommand extends ACommand {

    @Input
    private GeolocationRequestEntity requestEntity;

    @Override
    public GenericResponse execute() throws ApplicationException {
        try {
            IGeolocationBean geolocationBean = BeanFactory.getGeolocationBean();
            GenericResponse response = geolocationBean.locationChanged(requestEntity,getRequest().getSession(),request);
            return response;
        }
        catch (Exception e) {
            logger.severe("Exception in LocationChangedCommand");
            throw new ApplicationException("Exception in LocationChangedCommand", e);
        }
    }
}
