package com.company;

import com.company.Ships.Ship;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class User {

    private int m_health;
    private boolean hasWon = false;
    private String name = "";
    private List<Ship> listOfShips = new ArrayList<Ship>();


    //Getters and Setters
    public User(String name) {
        this.name = name;
    }

    public int getM_health() {
        return this.m_health;
    }

    public void setM_health(int m_health) {
        this.m_health = m_health;
    }

    public boolean isHasWon() {
        return this.hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public String getName() {
        return this.name;
    }

}
