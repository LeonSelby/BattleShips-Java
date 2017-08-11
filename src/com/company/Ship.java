package com.company;

import java.awt.*;

public class Ship {

    private int m_health = 0, m_length = 0;
    private String m_name = null;
    private Point[] locations = new Point[m_length];
    private boolean isHorizontal;
    private boolean m_alive = isAlive();

    //Constructor
    public Ship(int health) {
        this.m_health = health;
        this.m_length = health;
        this.m_alive = true;
        this.isHorizontal = isHorizontal();
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
    public void takeDamage (int damageTaken) {
        if (this.isM_alive()) {
            this.setM_health(this.getM_health() - damageTaken);
        }
    }

    //Getters and Setters
    public int getM_health() {
        return this.m_health;
    }

    public boolean isM_alive() {
        return this.m_alive;
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

    public  void declareLengthAndDir() {
        String direction = "";
        if (this.getIsHorizontal()) {
            direction = "horizontal";
        } else if (!this.getIsHorizontal()) {
            direction = "vertical";
        }
        System.out.println(direction + " " + this.getM_name()+", ship length is "
                + this.getM_length());
    }


    //Utility Booleans
    public boolean isAlive() {
        return m_health > 0;
    }


    //Utility Methods
    public int randomNumberUpTo(int min, int max) {
        int range = (max - min);
        return (int) (Math.random() * range) + min;
    }

    public boolean isHorizontal() {
        return randomNumberUpTo(0, 4) > 1;
    }
}
