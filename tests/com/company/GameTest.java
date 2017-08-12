package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.company.Grade.S;

public class GameTest {


    private Game testing;
    private TakeInput takeInput = new TakeInput();
    private User ai = new User();
    private  User player1 = new User();
    private  Board boardAI = new Board(7);
    private   Ship ship = new Ship(3);

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
        player1.setHealth(8);
        player1.setShotsTaken(8);
        player1.assignGrade();
        Assert.assertEquals(S, player1.getAssignedGrade());
    }


}
