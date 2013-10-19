package com.guide.city.dao;


import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.VisitedPlacesEntity;
import com.guide.city.exceptions.DAOException;

public class VisitedPlacesDAO extends BasicDAO<VisitedPlacesEntity, String> {
    public VisitedPlacesDAO(Datastore datastore) {
        super(datastore);
        datastore.ensureIndexes(VisitedPlacesEntity.class);
    }

    public VisitedPlacesEntity findByDeviceId(String deviceId) throws DAOException {
        try {
            return super.findOne("_id", deviceId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }
}
