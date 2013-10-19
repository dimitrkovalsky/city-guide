package com.guide.city.responses;

public class GenericResponse {
    private int requestType;
    private int responseType;
    private int responseCode;
    private Object response;

    public GenericResponse setResponseCode(int requestType) {
        this.responseCode = requestType;
        return this;
    }

    public int getRequestType() {
        return requestType;
    }

    public void setRequestType(int requestType) {
        this.requestType = requestType;
    }

    public int getResponseType() {
        return responseType;
    }

    public void setResponseType(int responseType) {
        this.responseType = responseType;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Object getResponse() {
        return response;
    }

    public GenericResponse setResponse(Object response) {
        this.response = response;
        return this;
    }
}
