package com.guide.city.commands.errors;


import com.guide.city.commands.ACommand;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseErrorCode;

public class AuthenticationFailedCommand extends ACommand {
    @Override
    public GenericResponse execute() throws ApplicationException {
        System.err.println("Authentication failed ");

        return ErrorFactory.createResponse(ResponseErrorCode.AUTHENTICATION_FAILED, "Authentication failed");
    }
}
