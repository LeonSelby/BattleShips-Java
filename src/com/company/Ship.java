package com.company;

import java.awt.*;

public class Ship {

    private int health = 0, length = 0;
    private String name = null;
    private Point[] locations = new Point[length];
    private boolean isHorizontal;
    private boolean m_alive = isAlive();

    //Constructor
    public Ship(int health) {
        this.health = health;
        this.length = health;
        this.m_alive = true;
        this.isHorizontal = isHorizontal();
        switch (health) {
            case 0:
                this.name = "Phantom Boat";
                break;
            case 1:
                this.name = "Patrol Boat";
                break;
            case 2:
                this.name = "Landing Craft";
                break;
            case 3:
                this.name = "Light Cruiser";
                break;
            case 4:
                this.name = "Frigate";
                break;
            case 5:
                this.name = "Dreadnought";
                break;
            case 6:
                this.name = "Ironclad";
                break;
            case 7:
                this.name = "Aircraft Cruiser";
                break;
            case 8:
                this.name = "Destroyer";
                break;
            case 9:
                this.name = "Battlecruiser";
                break;
            default:
                this.name = "Uberboat(" + health + ")";
                break;
        }
    }

    //Methods
    public void takeDamage (int damageTaken) {
        if (this.isAlive()) {
            this.setHealth(this.getHealth() - damageTaken);
        }
    }

    //Getters and Setters
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
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
        this.locations = new Point[this.length];
    }

    public void printLocationPoints(){
        String tmp = "";
        for (Point p:this.getLocation()) {
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
        System.out.println(direction + " " + this.getName()+", ship length is "
                + this.getLength());
    }


    //Utility Booleans
    public boolean isAlive() {
        return this.health > 0;
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
