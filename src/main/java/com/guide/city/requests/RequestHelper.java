package com.guide.city.requests;


import com.guide.city.commands.ACommand;
import com.guide.city.commands.errors.ErrorFactory;
import com.guide.city.commands.errors.NullCommand;
import com.guide.city.exceptions.ApplicationException;
import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseErrorCode;

public class RequestHelper {

    public static GenericResponse perform(ACommand c) {

        if (c == null)
            c = new NullCommand();

        GenericResponse response = null;
        try {
            response = c.execute();
        }
        catch (ApplicationException e) {
            response = ErrorFactory.createResponse(ResponseErrorCode.APPLICATION_EXCEPTION, e.getMessage());
        }

        return response;
    }
}
