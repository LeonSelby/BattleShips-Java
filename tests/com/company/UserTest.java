package com.company;

import org.junit.Before;

public class UserTest {

    Game game = new Game();
    TakeInput takeInput = new TakeInput();
    User ai;
    User testing;
    Board boardAI = new Board(7);
    Ship ship = new Ship(3);

    @Before
    public void setUp(){

        ai = new User();
        ai.setAI(true);
        testing = new User();

        game.setAI(ai);
        game.setPlayer1(testing);
        game.setAiGame(true);

    }





}
