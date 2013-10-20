package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.GameTimerEntity;
import com.guide.city.exceptions.DAOException;

/**
 * User: dkovalskyi
 * Date: 20.10.13
 * Time: 9:09
 */
public class GameTimerDAO extends BasicDAO<GameTimerEntity, String> {
    public GameTimerDAO(Datastore datastore) {
        super(datastore);
        datastore.ensureIndexes(GameTimerEntity.class);
    }

    public GameTimerEntity findByDeviceId(String deviceId) throws DAOException {
        try {
            return super.findOne("_id", deviceId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }
}