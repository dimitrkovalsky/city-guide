package com.guide.city.commands;


import com.guide.city.beans.interfaces.IAuthenticationBean;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.exceptions.ValidationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.helpers.JsonMapper;
import com.guide.city.requests.Validatable;
import com.guide.city.requests.entities.AuthenticationRequestEntity;
import com.guide.city.responses.entities.AuthenticationResponse;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;

import java.util.logging.Logger;

public class AuthenticationCommand extends ACommand implements Validatable {

    private AuthenticationRequestEntity requestEntity;
    private Logger logger = Logger.getLogger(AuthenticationCommand.class.getName());

    @Override
    public GenericResponse execute() throws ApplicationException {
        try {
            IAuthenticationBean authenticationBean = BeanFactory.getAuthenticationBean();
            SessionEntity session = new SessionEntity();
            session.setDeviceId(requestEntity.getDeviceId());
            String sk = authenticationBean.authenticate(session, requestEntity);
            AuthenticationResponse authenticationResponse = new AuthenticationResponse();
            authenticationResponse.setSecurityToken(sk);
            GenericResponse response = ResponseFactory.createResponse(request);
            response.setResponse(authenticationResponse);

            return response;
        }
        catch (Exception e) {
            logger.severe("Exception in AuthenticationCommand, authentication failed");
            throw new ApplicationException("Exception in AuthenticationCommand, authentication failed", e);
        }
    }

    @Override
    public void validate() throws ValidationException {
        JsonMapper mapper = new JsonMapper();
        requestEntity = mapper.convertValue(getRequestObject().getRequestData(), AuthenticationRequestEntity.class);
        if (requestEntity.getDeviceId() == null || requestEntity.getDeviceId().isEmpty()) {
            logger.severe("Device id is invalid");
            throw new ValidationException("Device id is invalid");
        }
    }
}
