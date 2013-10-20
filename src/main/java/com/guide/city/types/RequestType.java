package com.guide.city.types;


import com.guide.city.annotations.Handler;
import com.guide.city.commands.*;
import com.guide.city.commands.test.FirstTestCommand;
import com.guide.city.commands.test.RandomTestCommand;
import com.guide.city.commands.test.SecondTestCommand;

public interface RequestType {
    @Handler(FirstTestCommand.class)
    public static int RT_TEST_1 = 1;

    @Handler(SecondTestCommand.class)
    public static int RT_TEST_2 = 2;

    @Handler(RandomTestCommand.class)
    public static int RT_RANDOM_TEST = 3;

    @Handler(AuthenticationCommand.class)
    public static int RT_AUTHENTICATE = 100;

    @Handler(LocationChangedCommand.class)
    public static int RT_LOCATION_CHANGED = 110;

    @Handler(LocationCompletedCommand.class)
    public static  int LOCATION_COMPLETED = 120;

    @Handler(GameStartCommand.class)
    public static int START_GAME = 101;

    @Handler(GameCompletedCommand.class)
    public static int GAME_COMPLETED =  200;
}