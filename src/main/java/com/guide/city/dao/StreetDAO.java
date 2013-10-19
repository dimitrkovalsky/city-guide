package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.StreetEntity;
import com.guide.city.exceptions.DAOException;

import java.util.List;

/**
 * User: mkontarev
 * Date: 10/19/13
 * Time: 7:39 PM
 */
public class StreetDAO extends BasicDAO<StreetEntity, Integer>    {

    public StreetDAO(Datastore datastore) {
        super(datastore);
    }

    public StreetEntity find(Integer id) throws DAOException {
        try {
            return super.findOne("_id", id);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public void insert(StreetEntity street) throws DAOException {
        try {
            super.save(street);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public void update(StreetEntity street) throws DAOException {
        insert(street);
    }

    public List<StreetEntity> findAll() throws DAOException {
        return getDatastore().find(StreetEntity.class).asList();
    }
}
