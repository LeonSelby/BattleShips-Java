package com.company;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static com.company.Grade.*;

public class TakeInputTest {


    private Game newGame = new Game();
    private  TakeInput testing;
    private  User ai = new User();
    private User player1 = new User();
    private Board boardAI = new Board(7);
    private Ship ship = new Ship(3);

    @Before
    public void setUp() {
        testing = new TakeInput();
    }


    @Test
    public void stateGrade_Test() {
        System.out.println(TakeInput.stateGrade(A));
        System.out.println(TakeInput.stateGrade(B));
    }

    @Test
    @Ignore
    public void needIntInRange_Test() {
        TakeInput.needIntInRange(1, 3);
    }

    @Test
    @Ignore
    public void errorHandlingNeedIntInRange_Test() {
        TakeInput.requestInputInRange(TakeInput.askForShipSize
                (true), 2, 4);
    }

}
