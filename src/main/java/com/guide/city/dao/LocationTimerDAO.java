package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.GeolocationEntity;
import com.guide.city.entities.Location;
import com.guide.city.entities.LocationTimerEntity;
import com.guide.city.exceptions.DAOException;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * User: dkovalskyi
 * Date: 19.10.13
 * Time: 17:22
 */
public class LocationTimerDAO extends BasicDAO<LocationTimerEntity, ObjectId> {
    public LocationTimerDAO(Datastore datastore) {
        super(datastore);
        datastore.ensureIndexes(GeolocationEntity.class);
    }

    public LocationTimerEntity findByDeviceId(String deviceId) throws DAOException {
        try {
            return super.findOne("_id", deviceId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public List<GeolocationEntity> findNear(Location location, int limit) throws DAOException {
        try {
            return getDatastore().find(GeolocationEntity.class).field("location")
                    .near(location.getLatitude(), location.getLongitude(), 100 / 111.12).limit(limit).asList();
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

}