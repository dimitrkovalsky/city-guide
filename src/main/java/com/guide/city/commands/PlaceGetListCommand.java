package com.guide.city.commands;

import com.guide.city.beans.interfaces.IPlaceBean;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.responses.GenericResponse;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 10:13 AM
 */
public class PlaceGetListCommand extends ACommand {

    @Override
    public GenericResponse execute() throws ApplicationException {
        IPlaceBean placeBean = BeanFactory.getPlaceBean();
        GenericResponse response = placeBean.findAll(request);

        return response;
    }
}
