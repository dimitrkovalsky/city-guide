package com.guide.city.commands;

import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.responses.GenericResponse;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 10:23
 */
public class LocationCompletedCommand extends ACommand {
    @Override
    public GenericResponse execute() throws ApplicationException {
        try {
            return BeanFactory.getGeolocationBean().locationCompleted(getRequest().getSession(), getRequest());

        }
        catch (Exception e) {
            logger.severe("Exception in GameStartCommand,  failed");
            throw new ApplicationException("Exception in GameStartCommand,  failed", e);
        }
    }
}
