package com.company;

import org.junit.Before;
import org.junit.Test;

public class ShipTest {

    Game newGame = new Game();
    TakeInput takeInput = new TakeInput();
    User ai = new User("AI");
    User player1 = new User("Player One");
    Board boardAI = new Board(7);
    Ship testing = new Ship(5);

    @Before
    public void setUp(){
        testing = new Ship(5);
    }

    @Test
    public void constructor_Test(){
        System.out.println(testing.getM_length());
        System.out.println(testing.getIsHorizontal());
        System.out.println(testing.getM_health());
        System.out.println(testing.getM_name());

    }










}
