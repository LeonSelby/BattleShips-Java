package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.Grade.*;

public class User {

    private int health;
    private int dmgDone;
    private boolean hasWon = false;
    private List<Ship> listOfShips = new ArrayList<Ship>();
    private boolean isAI = false;
    private int shotsTaken = 0;
    private Grade assignedGrade;

    //Constructors

    //Getters and Setters
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Ship> getListOfShips() {
        return this.listOfShips;
    }

    public boolean isHasWon() {
        this.updateHasWon();
        return this.hasWon;
    }

    public void updateHasWon() {
        int dmgDone = this.getDmgDone();
        int health = this.getHealth();

        if (dmgDone == health) {
            this.setHasWon(true);
        } else {
            this.setHasWon(false);
        }
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public int getDmgDone() {
        return this.dmgDone;
    }

    public void setDmgDone(int dmgDone) {
        this.dmgDone = dmgDone;
    }

    public boolean isAI() {
        return this.isAI;
    }

    public void setAI(boolean AI) {
        this.isAI = AI;
    }

    public int getShotsTaken() {
        return this.shotsTaken;
    }

    public void setShotsTaken(int shotsTaken) {
        this.shotsTaken = shotsTaken;
    }

    public Grade getAssignedGrade() {
        this.assignGrade();
        return this.assignedGrade;
    }

    public void setAssignedGrade(Grade assignedGrade) {
        this.assignedGrade = assignedGrade;
    }

    //Methods
    public void addShipToUser(Ship ship) {
        this.listOfShips.add(ship);
    }

    public void shoot(Board board) {
        Point guessReq = new Point(0, 0);
        int guessX;
        int guessY;
        do {
            guessX = TakeInput.requestInputInRange(TakeInput.askForGuess("column"), 1, board.getBoardColumns()) - 1;
            guessY = TakeInput.requestInputInRange(TakeInput.askForGuess("row"), 1, board.getBoardColumns()) - 1;
            guessReq = new Point(guessY, guessX);
        } while (
                (!(guessIsInBounds(guessReq, board)))
                        &&
                        (!(board.boardArray[guessX][guessY] > 0)));
        this.markMarkWithShot(board, guessReq);
        this.shotsTaken++;
    }

    public void shootAsAI(Board board) {
        System.out.println("The AI takes aim...");
        Point guessReq = new Point(0, 0);
        int guessX, guessY;
        do {
            guessX = randomNumberUpTo(0, board.getBoardColumns());//MIGHT BE WRONG
            guessY = randomNumberUpTo(0, board.getBoardColumns());
            guessReq = new Point(guessY, guessX);
        } while ((!(guessIsInBounds(guessReq, board)))
                        &&
                        (!(board.boardArray[guessX][guessY] > 0)));
        this.markMarkWithShot(board, guessReq);
        this.shotsTaken++;
    }

    public void markMarkWithShot(Board board, Point guess) {
        if (board.boardArray[guess.x][guess.y] == 1) {
            System.out.println(TakeInput.guessResponse("hit"));
            board.boardArray[guess.x][guess.y] = 2;
            this.addDmgDone(1);
        } else if (board.boardArray[guess.x][guess.y] == -1) {
            System.out.println(TakeInput.guessResponse("miss"));
            board.boardArray[guess.x][guess.y] = 0;
        }
    }

    public void initHealth() {
        int hp = 0;
        for (Ship s : this.getListOfShips()) {
            hp += s.getLength();
        }
        this.setHealth(hp);
    }

    public void addDmgDone(int dmgDone) {
        int tmp = this.getDmgDone() + dmgDone;
        this.setDmgDone(tmp);
    }

    public void assignGrade() {
        int shotsTaken = this.getShotsTaken();
        int shotsRequired = this.getHealth();
        int score = shotsRequired / shotsTaken * 100;
        switch (score) {
            case 100:
                this.setAssignedGrade(S);
                break;
            case 90:
                this.setAssignedGrade(A);
                break;
            case 80:
                this.setAssignedGrade(B);
                break;
            case 70:
                this.setAssignedGrade(C);
                break;
            case 60:
                this.setAssignedGrade(D);
                break;
            case 50:
                this.setAssignedGrade(E);
                break;
            default:
                this.setAssignedGrade(F);
                break;
        }
    }

    //Utility
    public boolean guessIsInBounds(Point guess, Board board) {
        int xValue = guess.x;
        int yValue = guess.y;
        boolean tmp = true;
        if (xValue > board.getBoardRows() - 1) {
            tmp = false;
        }
        if (yValue > board.getBoardColumns() - 1) {
            tmp = false;
        }
        return tmp;

    }

    public int randomNumberUpTo(int min, int max) {
        int range = (max - min);
        return (int) (Math.random() * range) + min;
    }


}
