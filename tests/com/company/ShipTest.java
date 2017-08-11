package com.company;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    Game newGame = new Game();
    TakeInput takeInput = new TakeInput();
    User ai = new User("AI");
    User player1 = new User("Player One");
    Board boardAI = new Board(7);
    Ship testing;

    @Before
    public void setUp(){
        testing = new Ship(5);
    }

    @Test
    public void constructor_Test(){}

    testing.getH








}
