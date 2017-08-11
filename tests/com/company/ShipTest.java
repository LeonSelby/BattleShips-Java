package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class ShipTest {

    Game newGame = new Game();
    TakeInput takeInput = new TakeInput();
    User ai = new User("AI");
    User player1 = new User("Player One");
    Board boardAI = new Board(7);
    Ship testing;

    @Before
    public void setUp() {
        testing = new Ship(5);
    }

    @Test
    public void constructor_Test() {
        System.out.println(testing.getM_length());
        System.out.println(testing.getIsHorizontal());
        System.out.println(testing.getM_health());
        System.out.println(testing.getM_name());
        System.out.println(testing.isM_alive());
    }

    @Test
    public void takeDamage_Test() {
        testing.takeDamage(1);
        Assert.assertEquals(4, testing.getM_health());
    }

    @Ignore
    @Test
    public void declareOrientation_Test() {
        testing.declareLengthAndDir();
    }

    @Ignore
    @Test
    public void randomNumberGenerationBetweenRange_Test() {
        for (int i = 0; i < 20; i++) {
            System.out.println(testing.randomNumberUpTo(0, 2));
        }
    }




}
