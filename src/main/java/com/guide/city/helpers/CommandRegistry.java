package com.guide.city.helpers;

import com.guide.city.annotations.Handler;
import com.guide.city.commands.ACommand;
import com.guide.city.types.RequestType;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CommandRegistry {
    private static Logger logger = Logger.getLogger(CommandRegistry.class.getName());
    private static Map<Integer, Class<? extends ACommand>> commands = null;

    static {
        commands = new HashMap<Integer, Class<? extends ACommand>>();
        Class<RequestType> clazz = RequestType.class;
        try {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Handler.class))
                    commands.put(field.getInt(clazz), field.getAnnotation(Handler.class).value());
            }
        }
        catch (Exception e) {
            logger.severe("[CommandRegistry] static initialization error " + e.getMessage());
        }
    }

    public static ACommand getCommand(Integer requestType) {
        if (requestType == null)
            return null;
        Class<? extends ACommand> clazz = commands.get(requestType);
        if (clazz == null)
            return null;
        try {
            return clazz.newInstance();
        }
        catch (Exception e) {
            logger.severe("[CommandRegistry] getCommand method " + e.getMessage());
            return null;
        }
    }

}
