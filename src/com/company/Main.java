package com.company;

import com.company.Ships.Ship;
import com.company.board.Board;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Board board = new Board(5);

        Game newGame = new Game();

        Ship ship = new Ship(3);
        Ship ship2 = new Ship(2);

        testplacement(board, newGame, ship, 1);
        testplacement(board, newGame, ship2, 1);

        Point startLoc = newGame.getStartPoint(board, ship);
        newGame.addLocationsToShip(board, ship, startLoc);
        Point startLoc2 = newGame.getStartPoint(board, ship2);

        newGame.addLocationsToShip(board, ship2, startLoc2);
        
        board.displayBoard(board);

    }


    public static void testRandomno(Ship ship, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(ship.randomNumberInRange(0, 3));
        }

    }

    public static void testplacement(Board board, Game game, Ship ship, int times) {
        for (int i = 0; i < times; i++) {
            String direction = "";

            if (ship.getIsHorizontal()) {
                direction = "horizontal";
            } else if (!ship.getIsHorizontal()) {
                direction = "vertical";
            }
            System.out.println(direction + " " + ship+"ship length is " + ship.getM_length());
        }
    }
}


