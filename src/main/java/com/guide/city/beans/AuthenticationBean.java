package com.guide.city.beans;

import com.guide.city.beans.interfaces.IAuthenticationBean;
import com.guide.city.dao.AccountDAO;
import com.guide.city.dao.SessionDAO;
import com.guide.city.entities.AccountEntity;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.exceptions.AuthenticationException;
import com.guide.city.helpers.DAOFactory;
import com.guide.city.requests.entities.AuthenticationRequestEntity;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.UUID;

public class AuthenticationBean implements IAuthenticationBean {

    @Override
    public String authenticate(SessionEntity session, AuthenticationRequestEntity requestEntity)
            throws AuthenticationException {
        try {
            SessionDAO sessionDAO = DAOFactory.getSessionDAO();
            AccountDAO accountDAO = DAOFactory.getAccountDAO();
            // sessionDAO.insert(session);
            AccountEntity account = new AccountEntity();


            if (validateDeviceId(session)) {
                account.setDeviceId(session.getDeviceId());
            }
            else
                throw new AuthenticationException(
                        "[AuthenticationBean] error in validation of deviceId : " + session.getDeviceId());

            account = accountDAO.findByDeviceId(account.getDeviceId());
            // If it is new user
            if (account == null) {
                account = register(requestEntity);
            }

            session.setSecurityToken(new ObjectId());
            session.setLastActivity(new Date());
            session.setDeviceId(account.getDeviceId());

            if (sessionDAO.findByDeviceId(account.getDeviceId()) != null)
                sessionDAO.updateInternal(session);
            else
                sessionDAO.save(session);

            return session.getSecurityToken().toString();
        }
        catch (Exception e) {
            throw new AuthenticationException("Authentication error", e);
        }
    }

    @Override
    public AccountEntity register(AuthenticationRequestEntity data) throws ApplicationException {
        try {
            // TODO : validate device id
            AccountEntity accountEntity = new AccountEntity();
            accountEntity.setAccountId(new ObjectId());
            accountEntity.setDeviceId(data.getDeviceId());
            DAOFactory.getAccountDAO().save(accountEntity);
            return accountEntity;
        }
        catch (Exception e) {
            throw new AuthenticationException("Authentication error", e);
        }
    }

    @Override
    public SessionEntity getSession(String securityToken) throws AuthenticationException {
        try {
            return DAOFactory.getSessionDAO().findByToken(securityToken);
        }
        catch (Exception e) {
            throw new AuthenticationException("[AuthenticationBean] Authentication error in method getSession", e);
        }
    }

    private boolean validateDeviceId(SessionEntity session) {
        if (session.getDeviceId() != null && !session.getDeviceId().isEmpty())
            return true;
        return false;
    }

    @Override
    public void logout(SessionEntity session) throws ApplicationException {
        try {
            SessionDAO sessionDAO = DAOFactory.getSessionDAO();
            sessionDAO.delete(session);
        }
        catch (Exception e) {
            throw new AuthenticationException("[AuthenticationBean] Authentication error in method logout", e);
        }
    }
}

