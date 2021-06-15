package model;

import model.strikers.Striker;
import model.strikers.Striker1;
import model.strikers.Striker2;

import java.util.HashMap;

public class Player {
    private int id;
    private Striker striker;
    HashMap<Keys, Boolean> keysPressed;

    public Player(int id){
        if (id == 1)
            striker = new Striker1();
        if (id == 2)
            striker = new Striker2();
        keysPressed = new HashMap<Keys, Boolean>();
        setKeysPressed();
        this.id = id;
    }

    public int getStrikerX(){
        return striker.getX();
    }

    public int getStrikerY(){
        return striker.getY();
    }

    public int getStrikerRadius(){
        return striker.getRadius();
    }

    public void moveStriker(HashMap<Keys, Boolean> keysPressed, int width, int height){
        striker.move(keysPressed, width, height, id);
    }

    private void setKeysPressed(){
        for (Keys key : Keys.values()){
            keysPressed.put(key, false);
        }
    }

}
