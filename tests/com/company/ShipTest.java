package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;


public class ShipTest {

    Game newGame = new Game();
    TakeInput takeInput = new TakeInput();
    User ai = new User();
    User player1 = new User();
    Board boardAI = new Board(7);
    Ship testing;

    @Before
    public void setUp() {
        testing = new Ship(3);
    }

    @Test
    public void constructor_Test() {
        System.out.println(testing.getLength()+" length");
        System.out.println(testing.getIsHorizontal()+" orientation, true is horizontal.");
        System.out.println(testing.getHealth()+" hp");
        System.out.println(testing.getName());
//        System.out.println(testing.isM_alive()+" alive");
    }

    @Test
    public void takeDamage_Test() {
        testing.takeDamage(1);
        Assert.assertEquals(2, testing.getHealth());
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

    @Test
    public void add_Reset_Location_Test() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(2, 1);
        Point[] locArray = new Point[testing.getLength()];
        locArray[0] = p1;
        locArray[1] = p2;
        locArray[2] = p3;
        testing.setLocation(locArray);

        for (Point p : testing.getLocation()) {
            System.out.println(p.x);
        }
        testing.clearLocations();

        for (Point p : testing.getLocation()) {
            Assert.assertNull(p);
        }

    }

}
