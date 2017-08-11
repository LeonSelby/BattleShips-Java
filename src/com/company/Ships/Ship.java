package com.company.Ships;

import com.company.board.Board;

import java.awt.*;

public class Ship {

    private int m_health = 0, m_length = 0;
    private String m_name = null;
    private Point[] locations = new Point[m_length];
    private boolean isHorizontal = isHorizontal();
    private boolean m_alive = true;


    //Constructor
    public Ship(int health) {
        this.m_health = health;
        this.m_length = health;
        this.m_alive = true;
        switch (health) {
            case 0:
                this.m_name = "Phantom Boat";
                break;
            case 1:
                this.m_name = "Patrol Boat";
                break;
            case 2:
                this.m_name = "Landing Craft";
                break;
            case 3:
                this.m_name = "Light Cruiser";
                break;
            case 4:
                this.m_name = "Frigate";
                break;
            case 5:
                this.m_name = "Dreadnought";
                break;
            case 6:
                this.m_name = "Ironclad";
                break;
            case 7:
                this.m_name = "Aircraft Cruiser";
                break;
            case 8:
                this.m_name = "Destroyer";
                break;
            case 9:
                this.m_name = "Battlecruiser";
                break;
            default:
                this.m_name = "Uberboat(" + health + ")";
                break;
        }
    }

    //Methods
    public void takeDamage(Ship ship, int damageTaken) {
        if (ship.isAlive()) {
            ship.setM_health(ship.getM_health() - damageTaken);
        }
        if (!ship.isAlive()) {
            ship.setM_alive(false);
        }
    }


    //Getters and Setters
    public int getM_health() {
        return m_health;
    }

    public void setM_health(int m_health) {
        this.m_health = m_health;
    }

    public String getM_name() {
        return m_name;
    }

    public int getM_length() {
        return m_length;
    }

    public void setM_alive(boolean alive) {
        this.m_alive = alive;
    }

    public void setHorizontal(boolean horizontal) {
        this.isHorizontal = horizontal;
    }

    public boolean getIsHorizontal() {
        return this.isHorizontal;
    }


    public Point[] getLocation() {
        return this.locations;
    }

    public void setLocation(Point[] location) {
        this.locations = location;
    }

    public void clearLocations() {
        this.locations = new Point[this.m_length];
    }

    public void printLocationPoints(){
        String tmp = "";

        for (Point p:this.getLocation()
             ) {
            tmp+= " "+p;

        }
        System.out.println(tmp);
    }

    //Utility Booleans
    public boolean isAlive() {
        return m_health > 0;
    }


    //Utility Methods
    public int randomNumberInRange(int min, int max) {
        int range = (max - min);
        return (int) (Math.random() * range) + min;
    }

    public boolean isHorizontal() {
        return randomNumberInRange(0, 3) > 1;
    }
}
