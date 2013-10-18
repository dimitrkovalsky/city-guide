package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.DAOException;
import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

public class SessionDAO extends BasicDAO<SessionEntity, ObjectId> {
    public SessionDAO(Datastore datastore) {
        super(datastore);
        // Expire after 10 minutes
        datastore.getCollection(SessionEntity.class).ensureIndex(new BasicDBObject("lastActivity", 1), new BasicDBObject("expireAfterSeconds", 600));
    }

    public SessionEntity findByToken(String token) throws DAOException {
        try {
            return super.findOne("_id", new ObjectId(token));
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public SessionEntity findByDeviceId(String deviceId) throws DAOException {
        try {
            return super.findOne("deviceId", deviceId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public void updateInternal(SessionEntity session) throws DAOException {
        try {
            getCollection().remove(new BasicDBObject().append("deviceId", session.getDeviceId()));
            save(session);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }
}
