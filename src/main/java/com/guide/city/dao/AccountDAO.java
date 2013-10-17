package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.AccountEntity;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.DAOException;
import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;


public class AccountDAO extends BasicDAO<AccountEntity, ObjectId> {
    public AccountDAO(Datastore datastore) {
        super(datastore);
    }

    public AccountEntity findById(String accountId) throws DAOException {
        try {
            return super.findOne("_id", accountId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }

    public AccountEntity findByDeviceId(String deviceId) throws DAOException {
        try {
            return super.findOne("deviceId", deviceId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }
}