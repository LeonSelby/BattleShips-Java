package com.company;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static com.company.Grade.*;

public class TakeInputTest {


    Game newGame = new Game();
    TakeInput testing;
    User ai = new User("AI");
    User player1 = new User("Player One");
    Board boardAI = new Board(7);
    Ship ship = new Ship(3);

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
