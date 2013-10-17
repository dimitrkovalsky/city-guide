package com.guide.city.beans.interfaces;


import com.guide.city.entities.AccountEntity;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.exceptions.AuthenticationException;
import com.guide.city.requests.entities.AuthenticationRequestEntity;

public interface IAuthenticationBean {
    SessionEntity getSession(String securityToken) throws ApplicationException;

    void logout(SessionEntity session) throws ApplicationException;

    String authenticate(SessionEntity session, AuthenticationRequestEntity requestEntity)
            throws AuthenticationException;

    AccountEntity register(AuthenticationRequestEntity data) throws ApplicationException;
}
