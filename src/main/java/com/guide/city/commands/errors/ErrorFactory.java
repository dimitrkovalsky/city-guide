package com.guide.city.commands.errors;


import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseCode;


public class ErrorFactory {
    public static GenericResponse createResponse(int errorCode, String errorString){
        GenericResponse response = new GenericResponse();
        response.setResponseCode(ResponseCode.STATUS_FAIL);
        ErrorObject object = new ErrorObject(errorCode,errorString);
        response.setResponse(object);
        return response;
    }
}
