package com.guide.city.responses;


import com.guide.city.requests.GenericRequest;
import com.guide.city.types.ResponseCode;

public class ResponseFactory {

    public static GenericResponse createResponse() {
        GenericResponse response = null;
        response = new GenericResponse();
        response.setResponseCode(ResponseCode.STATUS_OK);

        return response;
    }

    public static GenericResponse createResponse(GenericRequest request) {
        return createResponse(request, request.getRequestType());
    }

    public static GenericResponse createResponse(GenericRequest request, int responseType) {
        GenericResponse response = createResponse();
        response.setRequestType(request.getRequestType());
        response.setResponseType(responseType);
        return response;
    }
}