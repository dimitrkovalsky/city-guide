package com.guide.city.commands;

import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.responses.GenericResponse;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 10:13
 */
public class GameCompletedCommand extends ACommand {

    @Override
    public GenericResponse execute() throws ApplicationException {
        try {
            return BeanFactory.getGeolocationBean().gameCompleted(getRequest().getSession(), getRequest());

        }
        catch (Exception e) {
            logger.severe("Exception in GameCompletedCommand, authentication failed");
            throw new ApplicationException("Exception in AuthenticationCommand, authentication failed", e);
        }
    }
}
