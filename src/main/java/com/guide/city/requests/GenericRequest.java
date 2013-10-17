package com.guide.city.requests;


import com.guide.city.entities.SessionEntity;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Dimitr
 * Date: 25.08.12
 * Time: 12:17
 */
public class GenericRequest
{
    /**
     * Request type that represents Handler Object
     */
    private int requestType;

    private SessionEntity session;

    private Object requestData;

    private HttpServletRequest servletRequest;



    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }
    public int getRequestType() {
        return requestType;
    }
    public void setRequestData(Object requestData) {
        this.requestData = requestData;
    }
    public Object getRequestData() {
        return requestData;
    }

    public HttpServletRequest getServletRequest() {
        return servletRequest;
    }

    public void setServletRequest(HttpServletRequest servletRequest) {
        this.servletRequest = servletRequest;
    }

    public SessionEntity getSession() {
        return session;
    }

    public void setSession(SessionEntity session) {
        this.session = session;
    }
}
