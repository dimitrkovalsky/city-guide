package com.guide.city.requests;

import com.guide.city.annotations.Input;
import com.guide.city.annotations.NotNull;
import com.guide.city.annotations.Validatable;
import com.guide.city.commands.ACommand;
import com.guide.city.exceptions.ValidationException;
import com.guide.city.helpers.JsonMapper;

import java.lang.reflect.Field;

public class BodyValidator {
    public boolean validateBody(ACommand command) {
        try {
            if (command.getClass().isAnnotationPresent(Validatable.class)) {
                // ((Validatable) command).validate();
                extractInput(command);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    private void extractInput(ACommand command)
            throws IllegalAccessException, InstantiationException, ValidationException {
        Class<?> clazz = command.getClass();
       // System.out.println("[extractInput] class : " + clazz);
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Input.class)) {
                field.setAccessible(true);
               // System.out.println("[extractInput] field : " + field);
                Class<?> validationClass = field.getType();
             //   System.out.println("[extractInput] validationClass : " + validationClass);
                field.set(command, getObject(validationClass, command.getRequestObject().getRequestData()));
            }
        }
    }

    private Object getObject(Class<?> validationClass, Object input)
            throws IllegalAccessException, InstantiationException, ValidationException {
        JsonMapper mapper = new JsonMapper();
        Object object = mapper.convertValue(input, validationClass);
        for (Field field : validationClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
              /*  System.out.println("getObject() field : " + field);
                System.out.println(object);
                System.out.println("getObject() field.get(object)" + field.get(object));
                */
                if (field.get(object) == null)
                    throw new ValidationException(field.getName() + " is null");

            }
        }
       // System.out.println("getObject object" + object);
        return object;
    }
}
