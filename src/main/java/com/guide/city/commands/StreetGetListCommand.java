package com.guide.city.commands;

import com.guide.city.beans.interfaces.IStreetBean;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.responses.GenericResponse;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 10:16 AM
 */
public class StreetGetListCommand extends ACommand {

    @Override
    public GenericResponse execute() throws ApplicationException {
        IStreetBean streetBean = BeanFactory.getStreetBean();
        GenericResponse response = streetBean.findAll(request);

        return response;
    }
}
