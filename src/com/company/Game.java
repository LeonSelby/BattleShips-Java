package com.company;

import com.company.*;
import com.company.Ships.Ship;
import com.company.board.Board;

import java.awt.Point;

public class Game {

    public void startGame(){
//       TakeInput.
    }








    public void placeShip(Board board, Ship ship) {
        Point startLoc = getStartPoint(board, ship);
        if(checkShipPlacements(ship, startLoc, board)){
            addLocationsToShip(board, ship, startLoc);
        }else{
            placeShip(board, ship);
        }
    }

    //Ship placement Logic
    public Point getStartPoint(Board board, Ship ship) {
        int temp = 0;
        int temp2 = 0;
        Point tmp = null;
        do {
            if (ship.getIsHorizontal()) {
                temp = ship.randomNumberInRange(0, board.getM_rows() - 2);
                temp2 = ship.randomNumberInRange(0, 3);
                tmp = new Point(temp, temp2);
            } else if (!ship.getIsHorizontal()) {
                temp = ship.randomNumberInRange(0, 3);
                temp2 = ship.randomNumberInRange(0, board.getM_rows() - 2);
                tmp = new Point(temp, temp2);
            }
        } while (!(board.m_board[temp][temp2] == -1));
        return tmp;
    }

    public void addLocationsToShip(Board board, Ship ship, Point startLoc) {
        Ship tmp = ship;
        Point[] tmep = makeShipLocArray(board, startLoc, ship);
        ship.setLocation(tmep);
    }

    public Point[] makeShipLocArray(Board board, Point startingLoc, Ship ship) {
        Point[] temp = new Point[ship.getM_length()];
        Point[] potentialLocs = new Point[ship.getM_length()];
        if (ship.getIsHorizontal()) {//HORIZONTAL, SO Y is length
            for (int i = 0; i < ship.getM_length(); i++) {
                if (!(board.m_board[startingLoc.x][startingLoc.y + i] == -1)) {
                    board.m_board[startingLoc.x][startingLoc.y + i] = 1;
                    potentialLocs[i] = new Point(startingLoc.x, startingLoc.y + i);
                    break;
                } else {
                    potentialLocs[i] = new Point(startingLoc.x, startingLoc.y + i);
                    board.m_board[startingLoc.x][startingLoc.y + i] = 1;//REMOVE WHEN DONE
                }
            }
        } else if (!ship.getIsHorizontal()) {
            for (int i = 0; i < ship.getM_length(); i++) {
                if (!(board.m_board[startingLoc.x + i][startingLoc.y] == -1)) {
                    board.m_board[startingLoc.x + i][startingLoc.y] = 1;
                    potentialLocs[i] = new Point(startingLoc.x + i, startingLoc.y);
                    break;
                } else {
                    potentialLocs[i] = new Point(startingLoc.x + i, startingLoc.y);
                    board.m_board[startingLoc.x + i][startingLoc.y] = 1;//REMOVE WHEN DONE
                }
            }
        }
        temp = potentialLocs;

        return temp;


    }

    public boolean checkShipPlacements(Ship ship, Point startingLoc, Board board) {
        boolean allValid = false;
        Point[] temp = new Point[ship.getM_length()];
        Point[] potentialLocs = new Point[ship.getM_length()];
        if (ship.getIsHorizontal()) {
            for (int i = 0; i < ship.getM_length(); i++) {
                if (!(board.m_board[startingLoc.x][startingLoc.y + i] == -1)) {
                    allValid = false;
                    break;
                } else {
                    allValid = true;
                }
            }
        } else if (!ship.getIsHorizontal()) {
            for (int i = 0; i < ship.getM_length(); i++) {
                if (!(board.m_board[startingLoc.x + i][startingLoc.y] == -1)) {
                    allValid = false;
                    break;
                } else {
                    allValid = true;
                }
            }
        }
        return allValid;
    }
}

