package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.Location;
import com.guide.city.entities.PlaceEntity;
import com.guide.city.exceptions.DAOException;

import java.util.List;

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

    public List<PlaceEntity> findAll() throws DAOException {
        return getDatastore().find(PlaceEntity.class).asList();
    }

    public PlaceEntity findNear(Location location) throws DAOException {
        try {
            List<PlaceEntity> places = getDatastore().find(PlaceEntity.class).field("location")
                    .near(location.getLatitude(), location.getLongitude(), 0.05 / 111.12).limit(1).asList();
            if (places == null || places.isEmpty()) {
                return null;
            } else {
                return places.get(0);
            }
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }
}