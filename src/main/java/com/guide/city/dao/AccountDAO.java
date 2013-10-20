package com.guide.city.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import com.guide.city.entities.AccountEntity;
import com.guide.city.exceptions.DAOException;
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

    public AccountEntity findByGoogleId(String googleId) throws DAOException {
        try {
            return super.findOne("googleId", googleId);
        }
        catch (Exception e) {
            throw new DAOException(e);
        }
    }
}