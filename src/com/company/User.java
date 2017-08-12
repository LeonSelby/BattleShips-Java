package com.company;

import com.company.Ship;
import com.company.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static com.company.Grade.*;

public class User {

    private int m_health;
    private int m_dmgDone;
    private boolean hasWon = false;
    private List<Ship> listOfShips = new ArrayList<Ship>();
    private boolean isAI = false;
    private int shotsTaken = 0;
    private Grade assignedGrade;

    //Constructors

    //Getters and Setters
    public int getM_health() {
        return this.m_health;
    }

    public void setM_health(int m_health) {
        this.m_health = m_health;
    }

    public List<Ship> getListOfShips() {
        return this.listOfShips;
    }

    public boolean isHasWon() {
        this.updateHasWon();
        return this.hasWon;
    }

    public void updateHasWon() {
        int dmgDone = this.getM_dmgDone();
        int health = this.getM_health();

        if (dmgDone == health) {
            this.setHasWon(true);
        } else {
            this.setHasWon(false);
        }
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public int getM_dmgDone() {
        return this.m_dmgDone;
    }

    public void setM_dmgDone(int m_dmgDone) {
        this.m_dmgDone = m_dmgDone;
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
            guessX = TakeInput.requestInput(TakeInput.askForGuess("column")) - 1;
            guessY = TakeInput.requestInput(TakeInput.askForGuess("row")) - 1;
            guessReq = new Point(guessY, guessX);
        } while (
                (!(guessIsInBounds(guessReq, board)))
                        &&
                        (!(board.m_board[guessX][guessY] > 0)));
        this.markMarkWithShot(board, guessReq);
        this.shotsTaken++;
    }

    public void markMarkWithShot(Board board, Point guess) {
        if (board.m_board[guess.x][guess.y] == 1) {
            System.out.println(TakeInput.guessResponse("hit"));
            board.m_board[guess.x][guess.y] = 2;
            this.addDmgDone(1);
        } else if (board.m_board[guess.x][guess.y] == -1) {
            System.out.println(TakeInput.guessResponse("miss"));
            board.m_board[guess.x][guess.y] = 0;
        }
    }

    public void initHealth() {
        int hp = 0;
        for (Ship s : this.getListOfShips()) {
            hp += s.getM_length();
        }
        this.setM_health(hp);
    }

    public void addDmgDone(int dmgDone) {
        int tmp = this.getM_dmgDone() + dmgDone;
        this.setM_dmgDone(tmp);
    }

    public void assignGrade() {
        int shotsTaken = this.getShotsTaken();
        int shotsRequired = this.getM_health();
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
        if (xValue > board.getM_rows() - 1) {
            tmp = false;
        }
        if (yValue > board.getM_columns() - 1) {
            tmp = false;
        }
        return tmp;

    }


}
