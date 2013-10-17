package com.guide.city.commands;


import com.guide.city.exceptions.ApplicationException;
import com.guide.city.requests.GenericRequest;
import com.guide.city.responses.GenericResponse;


public abstract class ACommand {
    protected GenericRequest request;
    public abstract GenericResponse execute() throws ApplicationException;
    public GenericRequest getRequest() {
        return request;
    }

    public void setRequestObject(GenericRequest request) {
        this.request = request;
    }

    public GenericRequest getRequestObject(){
        return  request;
    }
}
