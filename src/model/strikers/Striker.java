package model.strikers;

import model.Keys;

import java.util.HashMap;

public abstract class Striker {

    protected int y = 0;
    protected int x = 0;
    protected int speed;
    protected int radius;

    public Striker (){
        speed = 3;
        radius = 60;
    }
    public abstract void move(HashMap<Keys, Boolean> keysPressed, int width, int height, int id);

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getRadius(){
        return radius;
    }
}
