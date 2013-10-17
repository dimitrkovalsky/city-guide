package com.guide.city.commands.errors;


import com.guide.city.commands.ACommand;
import com.guide.city.responses.GenericResponse;
import com.guide.city.types.ResponseErrorCode;

public class MalformedCommand extends ACommand {
    @Override
    public GenericResponse execute() {
        System.err.println("Malformed commands ");

        return ErrorFactory.createResponse(ResponseErrorCode.MALFORMED_COMMAND, "Malformed commands");
    }
}
