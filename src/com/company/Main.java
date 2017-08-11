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

        ship.declareLengthAndDir();
        ship2.declareLengthAndDir();

        newGame.placeShip(board, ship);
        newGame.placeShip(board, ship2);
        board.displayBoard(board);
        System.out.println("Ship 1:");
        ship.printLocationPoints();
        System.out.println("Ship 2:");
        ship2.printLocationPoints();

    }


}


