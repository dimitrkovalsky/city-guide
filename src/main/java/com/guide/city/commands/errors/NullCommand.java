package com.guide.city.commands.errors;


import com.guide.city.commands.ACommand;
import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseErrorCode;

public class NullCommand extends ACommand {

    @Override
    public GenericResponse execute() {

        return ErrorFactory.createResponse(ResponseErrorCode.NULL_COMMAND, "Null command");
    }
}
