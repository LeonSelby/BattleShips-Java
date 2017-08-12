package com.company;

import com.company.Ship;
import com.company.Board;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int m_health;
    private int m_dmgDone;
    private boolean hasWon = false;
    private List<Ship> listOfShips = new ArrayList<Ship>();
    private boolean isAI = false;

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

    public void updateHasWon(){
        int dmgDone = this.getM_dmgDone();
        int health = this.getM_health();

        if(dmgDone==health){
            this.setHasWon(true);
        }else{
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
        return isAI;
    }

    public void setAI(boolean AI) {
        this.isAI = AI;
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
            guessX = TakeInput.requestInput(TakeInput.askForGuess("column"))-1;
            guessY = TakeInput.requestInput(TakeInput.askForGuess("row"))-1;
            guessReq = new Point(guessY, guessX);
        } while (
                (!(guessIsInBounds(guessReq, board)))
                &&
                (!(board.m_board[guessX][guessY] > 0)));
        this.markMarkWithShot(board,guessReq);
    }

    public void markMarkWithShot(Board board, Point guess){
if(board.m_board[guess.x][guess.y] == 1){
    System.out.println(TakeInput.guessResponse("hit"));
    board.m_board[guess.x][guess.y] = 2;
    this.addDmgDone(1);
        }else if(board.m_board[guess.x][guess.y]==-1){
    System.out.println(TakeInput.guessResponse("miss"));
    board.m_board[guess.x][guess.y] = 0;
        }
    }

    public void initHealth(){
        int health = 0;
        for (Ship s:this.getListOfShips()) {
            health += s.getM_length();
        }
        this.setM_health(health);
    }

    public void addDmgDone(int dmgDone){
        int tmp = this.getM_dmgDone() +dmgDone;
        this.setM_health(tmp);
    }


    public boolean guessIsInBounds(Point guess, Board board) {
        int xValue = guess.x;
        int yValue = guess.y;
        boolean tmp = true;
        if (xValue > board.getM_rows()-1) {
            tmp = false;
        }
        if (yValue > board.getM_columns()-1) {
            tmp = false;
        }
        return tmp;

    }


}
