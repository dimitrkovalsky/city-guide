package com.guide.city.commands;

import com.guide.city.annotations.Input;
import com.guide.city.annotations.Validatable;
import com.guide.city.beans.interfaces.IStreetBean;
import com.guide.city.entities.StreetEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.requests.entities.IdEntity;
import com.guide.city.responses.GenericResponse;

/**
 * User: mkontarev
 * Date: 10/20/13
 * Time: 10:16 AM
 */
@Validatable
public class StreetGetCommand extends ACommand {

    @Input
    private IdEntity idEntity;

    @Override
    public GenericResponse execute() throws ApplicationException {
        IStreetBean streetBean = BeanFactory.getStreetBean();
        StreetEntity street = new StreetEntity(idEntity.getId());
        GenericResponse response = streetBean.find(street, request);

        return response;
    }
}
