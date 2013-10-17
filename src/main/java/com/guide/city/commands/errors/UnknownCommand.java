package com.guide.city.commands.errors;


import com.guide.city.commands.ACommand;
import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseErrorCode;

public class UnknownCommand extends ACommand {
    @Override
    public GenericResponse execute() {
        System.err.println("Unknown commands : " + request.getRequestType());

        return ErrorFactory.createResponse(ResponseErrorCode.UNKNOWN_COMMAND, "Request type is not supported");
    }
}
