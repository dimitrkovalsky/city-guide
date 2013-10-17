package com.guide.city.commands.test;


import com.guide.city.commands.ACommand;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;

public class SecondTestCommand extends ACommand {
    @Override
    public GenericResponse execute() {
        System.out.println("Second Test");

        return ResponseFactory.createResponse(request).setResponse(new TestObject());
    }
}
