package com.guide.city.dao;


import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.GeolocationEntity;
import com.guide.city.exceptions.DAOException;

public class GeolocationDAO extends BasicDAO<GeolocationEntity, String> {
    public GeolocationDAO(Datastore datastore) {
        super(datastore);
    }

    public GeolocationEntity findByDeviceId(String deviceId) throws DAOException {
        try {
            return super.findOne("_id", deviceId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

}