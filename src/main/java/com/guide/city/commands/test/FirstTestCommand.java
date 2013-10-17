package com.guide.city.commands.test;


import com.guide.city.commands.ACommand;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;

public class FirstTestCommand extends ACommand {
    @Override
    public GenericResponse execute() {
        System.out.println("First TEST");

        return ResponseFactory.createResponse(request).setResponse("First test command response object");
    }
}
