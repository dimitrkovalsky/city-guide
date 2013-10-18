package com.guide.city.commands;


import com.guide.city.annotations.Input;
import com.guide.city.annotations.Validatable;
import com.guide.city.beans.interfaces.IAuthenticationBean;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.requests.entities.AuthenticationRequestEntity;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;
import com.guide.city.responses.entities.AuthenticationResponse;

@Validatable
public class AuthenticationCommand extends ACommand{

    @Input
    private AuthenticationRequestEntity requestEntity;


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
}
