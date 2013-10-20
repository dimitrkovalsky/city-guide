package com.guide.city.commands;

import com.guide.city.annotations.Input;
import com.guide.city.annotations.Validatable;
import com.guide.city.beans.interfaces.IPlaceBean;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.requests.entities.IdEntity;
import com.guide.city.responses.GenericResponse;

/**
 * User: mkontarev
 * Date: 10/19/13
 * Time: 8:13 PM
 */
@Validatable
public class PlaceGetCommand extends ACommand {

    @Input
    private IdEntity idEntity;

    @Override
    public GenericResponse execute() throws ApplicationException {
        IPlaceBean placeBean = BeanFactory.getPlaceBean();
        PlaceEntity place = new PlaceEntity(idEntity.getId());
        GenericResponse response = placeBean.find(place, request);

        return response;
    }
}
