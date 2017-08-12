package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {


    Game testing;
    TakeInput takeInput = new TakeInput();
    User ai = new User("AI");
    User player1 = new User("Player One");
    Board boardAI = new Board(7);
    Ship ship = new Ship(3);

    @Before
    public void setUp(){
        testing = new Game();
    }

    @Test
    public void aiGameSetter_Test(){
        testing.setAiGame(true);
        Assert.assertTrue(testing.isAiGameGetter());
    }
//
//    @Test
//    public void


}
