package com.guide.city.requests;


import com.guide.city.commands.ACommand;
import com.guide.city.commands.errors.UnknownCommand;
import com.guide.city.commands.test.FirstTestCommand;
import com.guide.city.commands.test.RandomTestCommand;
import com.guide.city.commands.test.SecondTestCommand;
import com.guide.city.exceptions.ValidationException;
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
        return true;
//        String securityToken = getHttpRequest().getParameter("sk");
//        if (securityToken == null || securityToken.isEmpty()) {
//            if (getGenericRequest().getRequestType() != RequestType.RT_AUTHENTICATE)
//                return false;
//            else
//                return true;
//        }
//        else {
//            if (securityToken.matches("[a-z0-9\\-]{36}") == false)
//                return false;
//            SessionEntity session = null;
//            try {
//                IAuthenticationBean authenticationBean = SpringBeans.getAuthenticationBean();
//                session = authenticationBean.getSession(securityToken);
//
//                if (session != null) {
//                    session.setIpAddress(getHttpRequest().getRemoteAddr());
//                    getGenericRequest().setSession(session);
//                    return true;
//                }
//                else
//                    return false;
//            }
//            catch (Exception e) {
//                return false;
//            }
//        }
    }

    @Override
    protected boolean validateBody() {
        BodyValidator validator = new BodyValidator();
        return validator.validateBody(getCommand());
    }

    public ACommand getCommandObject() {
        ACommand outCommand = null;
        switch (getGenericRequest().getRequestType()) {
            case RequestType.RT_TEST_1:
                outCommand = new FirstTestCommand();
                break;
            case RequestType.RT_TEST_2:
                outCommand = new SecondTestCommand();
                break;
            case RequestType.RT_RANDOM_TEST:
                outCommand = new RandomTestCommand();
                break;
        }


        if (outCommand == null)
            outCommand = new UnknownCommand();

        outCommand.setRequestObject(getGenericRequest());

        return outCommand;
    }
}
