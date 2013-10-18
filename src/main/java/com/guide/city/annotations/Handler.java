package com.guide.city.annotations;

import com.guide.city.commands.ACommand;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value= ElementType.FIELD)
public @interface Handler {
    public Class<? extends ACommand> value();
}