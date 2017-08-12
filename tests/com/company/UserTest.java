package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private Game game = new Game();
    private TakeInput takeInput = new TakeInput();
    private User ai;
    private User testing;
    private  Board boardAI = new Board(7);
    private Ship ship = new Ship(3);
    private Ship ship2 = new Ship(5);


    @Before
    public void setUp() {

        ai = new User();
        ai.setAI(true);
        testing = new User();

        game.setAI(ai);
        game.setPlayer1(testing);
        game.setAiGame(true);


    }

    @Test
    public void addDmgDone_Test() {

        testing.addDmgDone(1);
        Assert.assertEquals(1, testing.getDmgDone());
        testing.addDmgDone(1);
        Assert.assertEquals(2, testing.getDmgDone());
    }

    @Test
    public void initialiseHP_Test() {
        testing.addShipToUser(ship);
        testing.addShipToUser(ship2);
        testing.initHealth();
        Assert.assertEquals(8, testing.getHealth());
    }

    @Test
    public void updateHasWon_Test(){
       //Sets 8 as the HP of User (same for both users)
        testing.addShipToUser(ship);
        testing.addShipToUser(ship2);
        testing.initHealth();

        //Sets 8 to dmg done to user
        testing.addDmgDone(8);

        //IsHasWon checks if dmgDone=HP.
        Assert.assertTrue(testing.isHasWon());
    }






    @Test
    public void shoot_Test(){}






}
