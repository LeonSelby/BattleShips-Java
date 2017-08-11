package com.company;

import com.company.*;
import com.company.Ships.Ship;
import com.company.board.Board;

import java.awt.Point;

public class Game {


    public Point getStartPoint(Board board, Ship ship) {
        int temp=0;
        int temp2=0;
        Point tmp = null;
        do {
            if (ship.getIsHorizontal()) {
                int[][] validHorizontalBoard = new int[board.getM_columns()][ship.getM_length()];
                temp = ship.randomNumberInRange(0, board.getM_rows() - 2);
                temp2 = ship.randomNumberInRange(0, 3);
                tmp = new Point(temp, temp2);
            } else if (!ship.getIsHorizontal()) {
                temp = ship.randomNumberInRange(0, 3);
                temp2 = ship.randomNumberInRange(0, board.getM_rows() - 2);
                tmp = new Point(temp, temp2);
            }
        }while(!(board.m_board[temp][temp2]==-1));
        return tmp;
    }

    public Ship addLocationsToShip(Board board, Ship ship, Point startLoc) {
        Ship tmp = ship;
        Point[] locationsArr = checkShipPlacements(ship, startLoc, board);

        ship.setLocation(locationsArr);

        return tmp;
    }

    public Point[] checkShipPlacements(Ship ship, Point startingLoc, Board board) {
        boolean allValid = false;
        Point[] temp = new Point[ship.getM_length()];
        Point[] potentialLocs = new Point[ship.getM_length()];
        System.out.println("Starting loc" + startingLoc);
        if (ship.getIsHorizontal()) {//HORIZONTAL, SO Y is length
            for (int i = 0; i < ship.getM_length(); i++) {
                if (!(board.m_board[startingLoc.x][startingLoc.y + i] == -1)) {
                    board.m_board[startingLoc.x][startingLoc.y + i] = 1;
                    potentialLocs[i] = new Point(startingLoc.x, startingLoc.y + i);
                    allValid = false;
                    break;
                } else {
                    potentialLocs[i] = new Point(startingLoc.x, startingLoc.y + i);
                    board.m_board[startingLoc.x][startingLoc.y + i] = 1;//REMOVE WHEN DONE
                    allValid = true;
                }
            }
        } else if (!ship.getIsHorizontal()) {
            for (int i = 0; i < ship.getM_length(); i++) {
                if (!(board.m_board[startingLoc.x+i][startingLoc.y] == -1)) {
                    board.m_board[startingLoc.x+i][startingLoc.y] = 1;
                    potentialLocs[i] = new Point(startingLoc.x+i, startingLoc.y);
                    allValid = false;
                    break;
                } else {
                    potentialLocs[i] = new Point(startingLoc.x+i, startingLoc.y);
                    board.m_board[startingLoc.x+i][startingLoc.y] = 1;//REMOVE WHEN DONE
                    allValid = true;
                }
            }

            }

            if (allValid) {
                temp = potentialLocs;
            }


        return temp;
    }
}

