package com.guide.city.commands.test;

import com.guide.city.commands.ACommand;
import com.guide.city.helpers.Views;
import com.guide.city.responses.GenericResponse;
import com.guide.city.responses.ResponseFactory;
import org.codehaus.jackson.map.annotate.JsonView;

import java.util.Random;


public class RandomTestCommand extends ACommand {
    @Override
    public GenericResponse execute() {
        System.out.println("RandomTestCommand invoked");
        int resp = Math.abs(new Random().nextInt()) % 3 + 1;
        if (resp == 1)
            return ResponseFactory.createResponse(request, resp).setResponse("String response");
        if (resp == 2)
            return ResponseFactory.createResponse(request, resp).setResponse(100500);

        return ResponseFactory.createResponse(request, resp).setResponse(new SimpleObject());
    }
}

class SimpleObject {

    @JsonView(Views.Public.class)
    private int value;

    @JsonView(Views.Public.class)
    private String string = "Simple string";

    public SimpleObject() {
        value = Math.abs(new Random().nextInt() % 1000);
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    String getString() {
        return string;
    }

    void setString(String string) {
        this.string = string;
    }
}

