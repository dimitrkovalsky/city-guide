package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.exceptions.DAOException;

public class PlaceDAO extends BasicDAO<PlaceEntity, Integer> {

    public PlaceDAO(Datastore datastore) {
        super(datastore);
    }

    public PlaceEntity find(Integer id) throws DAOException {
        try {
            return super.findOne("_id", id);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public void insert(PlaceEntity place) throws DAOException {
        try {
            super.save(place);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public void update(PlaceEntity place) throws DAOException {
        insert(place);
    }
}
