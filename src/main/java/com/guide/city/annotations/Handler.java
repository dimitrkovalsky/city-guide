package com.guide.city.annotations;

import com.guide.city.commands.ACommand;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Handler {
    public Class<? extends ACommand> value();
}
