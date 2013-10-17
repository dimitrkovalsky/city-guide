package com.guide.city.requests;


import com.guide.city.beans.interfaces.IAuthenticationBean;
import com.guide.city.commands.ACommand;
import com.guide.city.commands.errors.UnknownCommand;
import com.guide.city.entities.SessionEntity;
import com.guide.city.exceptions.ValidationException;
import com.guide.city.helpers.BeanFactory;
import com.guide.city.helpers.CommandRegistry;
import com.guide.city.helpers.JsonMapper;
import com.guide.city.types.RequestType;

import javax.servlet.http.HttpServletRequest;

public class GenericRequestProcessor extends ARequestProcessor {

    public GenericRequestProcessor(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    @Override
    protected boolean validateBase() {
        String requestData = getHttpRequest().getParameter("request");
        if (requestData == null || requestData.length() == 0)
            return false;
        else
            return true;
    }

    @Override
    protected GenericRequest getRequestObject() throws ValidationException {
        String requestData = getHttpRequest().getParameter("request");
        //     System.out.println("REQUEST>>>>>>>>> " + requestData);
        JsonMapper mapper = new JsonMapper();

        try {
            GenericRequest request = mapper.readValue(requestData, GenericRequest.class);
            request.setServletRequest(getHttpRequest());
            //request.setSession(getRequestObject().getSession());
            return request;
        }
        catch (Exception e) {
            throw new ValidationException(e);
        }
    }

    @Override
    protected boolean validateAuthentication() {
        String securityToken = getHttpRequest().getParameter("sk");
        if (securityToken == null || securityToken.isEmpty()) {
            if (getGenericRequest().getRequestType() != RequestType.RT_AUTHENTICATE)
                return false;
            else
                return true;
        }
        else {
            SessionEntity session = null;
            try {
                IAuthenticationBean authenticationBean = BeanFactory.getAuthenticationBean();
                session = authenticationBean.getSession(securityToken);

                if (session != null) {
                    getGenericRequest().setSession(session);
                    return true;
                }
                else
                    return false;
            }
            catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    protected boolean validateBody() {
        BodyValidator validator = new BodyValidator();
        return validator.validateBody(getCommand());
    }

    public ACommand getCommandObject() {
        ACommand outCommand = CommandRegistry.getCommand(getGenericRequest().getRequestType());
        if (outCommand == null)
            outCommand = new UnknownCommand();

        outCommand.setRequestObject(getGenericRequest());

        return outCommand;
    }
}
