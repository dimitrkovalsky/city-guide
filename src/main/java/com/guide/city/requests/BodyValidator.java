package com.guide.city.requests;

import com.guide.city.commands.ACommand;

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
}
