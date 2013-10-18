package com.guide.city.requests;

import com.guide.city.annotations.Input;
import com.guide.city.commands.ACommand;

import java.lang.reflect.Field;

public class BodyValidator {
    public boolean validateBody(ACommand command) {
        try {
            if (command instanceof Validatable) {
                ((Validatable) command).validate();
            }
        }
        catch (Exception e) {
            return false;
        }

        return true;
    }

    private void extractInput(ACommand command) {
        Class<?> clazz = command.getClass();
        for(Field field : clazz.getFields()){
            if(field.isAnnotationPresent(Input.class)){

            }
        }
    }
}
