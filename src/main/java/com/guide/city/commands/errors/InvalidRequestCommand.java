package com.guide.city.commands.errors;


import com.guide.city.commands.ACommand;
import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseErrorCode;

public class InvalidRequestCommand extends ACommand {
    @Override
    public GenericResponse execute() {

        return ErrorFactory.createResponse(ResponseErrorCode.INVALID_REQUEST, "Request is invalid");
    }
}
