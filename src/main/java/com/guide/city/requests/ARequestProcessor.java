package com.guide.city.requests;


import com.guide.city.commands.ACommand;
import com.guide.city.commands.errors.AuthenticationFailedCommand;
import com.guide.city.commands.errors.InvalidRequestCommand;
import com.guide.city.commands.errors.MalformedCommand;
import com.guide.city.exceptions.ValidationException;

import javax.servlet.http.HttpServletRequest;


public abstract class ARequestProcessor {

    protected HttpServletRequest httpRequest;
    private GenericRequest genericRequest;
    private ACommand command;

    abstract protected boolean validateBase();
    abstract protected boolean validateBody();
    abstract protected ACommand getCommandObject();
    protected abstract boolean validateAuthentication();
    abstract protected GenericRequest getRequestObject() throws ValidationException;

    public ARequestProcessor(HttpServletRequest request) {
        this.httpRequest = request;
    }

    public ACommand process() {

        if (!validateBase())
            return new MalformedCommand();

        try {
            genericRequest = getRequestObject();
            setGenericRequest(genericRequest);
        } catch (ValidationException e) {
            return new MalformedCommand();
        }

        if(!validateAuthentication())
            return new AuthenticationFailedCommand();


        if ((command = getCommandObject()) == null)
            return new MalformedCommand();

        if (!validateBody()) {
            return new InvalidRequestCommand();
        }

        return command;
    }

    protected void setHttpRequest(HttpServletRequest httpRequest) {
        this.httpRequest = httpRequest;
    }
    protected HttpServletRequest getHttpRequest() {
        return httpRequest;
    }
    protected void setGenericRequest(GenericRequest genericRequest) {
        this.genericRequest = genericRequest;
    }
    protected GenericRequest getGenericRequest() {
        return genericRequest;
    }
    protected ACommand getCommand() {
        return command;
    }


}