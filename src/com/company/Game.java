package com.company;

import java.awt.*;

public class Game {

    private Board boardPlayer1;
    private Board boardPlayer2;
    private Board boardAI;
    private User AI;
    private User player1;
    private User player2;
    private boolean aiGame = false;


    public boolean isAIGame() {
        boolean ans = TakeInput.requestYesOrNo(TakeInput.askIfAiGame());
        if (ans) {
            this.setAiGame(true);
        }
        return ans;
    }

    public void startGame() {
        System.out.println(TakeInput.welcomeMessage() + "\n");
        boolean aiGame = isAIGame();
        int boardSize = TakeInput.requestInput(TakeInput.askForBoardSize());
        int shipAmount = TakeInput.requestInput(TakeInput.askForShipAmount());

        if (aiGame) {
            this.player1 = new User();
            this.AI = new User();
            this.AI.setAI(true);
            this.boardAI = new Board(boardSize);
            mainAIGameStages(shipAmount);
        } else {
            player1 = new User();
            this.boardPlayer1 = new Board(boardSize);
            player2 = new User();
            this.boardPlayer2 = new Board(boardSize);
        }
    }

    public void mainAIGameStages(int shipAmount) {

        shipSetupProcess(this.boardAI, this.AI, shipAmount);
        do {
            displayBoard(boardAI);
            player1.shoot(boardAI);
            System.out.println(player1.getM_dmgDone() + " out of " + player1.getM_health());
        } while (!player1.isHasWon());

        System.out.println(TakeInput.resultString("1"));
        System.out.println(TakeInput.stateGrade(player1.getAssignedGrade()));
    }


    public void displayBoard(Board board) {
        System.out.println(board.appendHeadings(board));
        System.out.println(board.appendHeadings2(board)); // DELETE BEFORE GOING LIVE, PRINTS REAL LEFT CO-ORDS
        for (int row = 0; row < board.getM_rows(); row++) {
            System.out.println();
            System.out.print((row + 1) + "");
            System.out.print((" " + row) + ""); //DELETE BEFORE GOING LIVE
            for (int column = 0; column < board.getM_columns(); column++) {
                if (board.m_board[row][column] == -1) {
                    System.out.print("\t" + "`");
                }//Changes initial state from -1 to -
                else if (board.m_board[row][column] == 0) {
                    System.out.print("\t" + "M");
                }//Changes a 0 to M (Must write method in guess to change -1 to 0 on miss)
                else if (board.m_board[row][column] == 1) {
                    System.out.print("\t" + "S");
                }//Changes a 1 to ` (Must write method in guess to change -1 to 1 on ship)
                else if (board.m_board[row][column] == 2) {
                    System.out.print("\t" + "X");
                    //Changes a 2 to X (Must write method in guess to change -1 to 1 on hit)
                }
            }
        }
        System.out.println();
    }


    //Ship placement Logic
    public void shipSetupProcess(Board board, User user, int shipAmount) {
        int shipSize;
        for (int i = 0; i < shipAmount; i++) {
            if (i == 0) {
                shipSize = TakeInput.requestInputInRange(TakeInput.askForShipSize(true), board.getM_rows());
                Ship ship = new Ship(shipSize);
                placeShip(board, ship);
                user.addShipToUser(ship);
            } else if (i == shipAmount - 1) {
                shipSize = TakeInput.requestInputInRange(TakeInput.askForShipSizeLast(), board.getM_rows());
                Ship ship = new Ship(shipSize);
                placeShip(board, ship);
                user.addShipToUser(ship);
            } else {
                shipSize = TakeInput.requestInputInRange(TakeInput.askForShipSize(false), board.getM_rows());
                Ship ship = new Ship(shipSize);
                placeShip(board, ship);
                user.addShipToUser(ship);
            }
        }
        user.initHealth();
        player1.setM_health(user.getM_health());
    }

    public void placeShip(Board board, Ship ship) {
        Point startLoc = getStartPoint(board, ship);
        if (checkShipPlacements(ship, startLoc, board)) {
            addLocationsToShip(board, ship, startLoc);
        } else {
            placeShip(board, ship);
        }
    }

    public Point getStartPoint(Board board, Ship ship) {
        int temp = 0;
        int temp2 = 0;
        Point tmp = null;
        do {
            if (ship.getIsHorizontal()) {
                temp = ship.randomNumberUpTo(0, board.getM_rows() - 2);
                temp2 = ship.randomNumberUpTo(0, 3);
                tmp = new Point(temp, temp2);
            } else if (!ship.getIsHorizontal()) {
                temp = ship.randomNumberUpTo(0, 3);
                temp2 = ship.randomNumberUpTo(0, board.getM_rows() - 2);
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


//Getters and Setters

    public Board getBoardPlayer1() {
        return this.boardPlayer1;
    }

    public void setBoardPlayer1(Board boardPlayer1) {
        this.boardPlayer1 = boardPlayer1;
    }

    public Board getBoardPlayer2() {
        return this.boardPlayer2;
    }

    public void setBoardPlayer2(Board boardPlayer2) {
        this.boardPlayer2 = boardPlayer2;
    }

    public Board getBoardAI() {
        return this.boardAI;
    }

    public void setBoardAI(Board boardAI) {
        this.boardAI = boardAI;
    }

    public User getAI() {
        return this.AI;
    }

    public void setAI(User AI) {
        this.AI = AI;
    }

    public User getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public boolean isAiGameGetter() {
        return this.aiGame;
    }

    public void setAiGame(boolean aiGame) {
        this.aiGame = aiGame;
    }
}

