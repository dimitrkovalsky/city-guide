package com.guide.city.commands;

import com.guide.city.annotations.Input;
import com.guide.city.annotations.Validatable;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.requests.entities.GeolocationRequestEntity;
import com.guide.city.responses.GenericResponse;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 10:13
 */
@Validatable
public class GameStartCommand extends ACommand {
    @Input
    private GeolocationRequestEntity requestEntity;

    @Override
    public GenericResponse execute() throws ApplicationException {
        try {
            return BeanFactory.getGeolocationBean().gameStart(requestEntity, getRequest().getSession(), getRequest());

        }
        catch (Exception e) {
            logger.severe("Exception in GameStartCommand,  failed");
            throw new ApplicationException("Exception in GameStartCommand,  failed", e);
        }
    }
}
