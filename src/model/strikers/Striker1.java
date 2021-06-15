package model.strikers;

import model.Keys;

import java.util.HashMap;

public class Striker1 extends Striker{

    public Striker1() {
        super();
        x = 300;
        y = 0;
    }
    @Override
    public void move(HashMap<Keys, Boolean> keysPressed, int width, int height, int id){
        if (y + radius + speed <= height / 2 && keysPressed.get(Keys.DOWN)) {
            y += speed;
        }
        if (y - speed >= 0 && keysPressed.get(Keys.UP)) {
            y -= speed;
        }
        if (x - speed >= 0 && keysPressed.get(Keys.LEFT)) {
            x -= speed;
        }
        if (x + radius + speed <= width && keysPressed.get(Keys.RIGHT)) {
            x += speed;
        }

    }
}
