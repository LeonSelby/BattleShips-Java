package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.Grade.S;

public class GameTest {


    Game testing;
    TakeInput takeInput = new TakeInput();
    User ai = new User();
    User player1 = new User();
    Board boardAI = new Board(7);
    Ship ship = new Ship(3);

    @Before
    public void setUp() {
        testing = new Game();
    }

    @Test
    public void aiGameSetter_Test() {
        testing.setAiGame(true);
        Assert.assertTrue(testing.isAiGameGetter());
    }

    @Test
    public void assignGrade_Test() {
        player1.setM_health(8);
        player1.setShotsTaken(8);
        player1.assignGrade();
        Assert.assertEquals(S, player1.getAssignedGrade());
    }


}
