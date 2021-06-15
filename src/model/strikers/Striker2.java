package model.strikers;

import model.Keys;

import java.util.HashMap;

public class Striker2 extends Striker{
    public Striker2() {
        super();
        x = 300;
        y = 700;
    }

    @Override
    public void move(HashMap<Keys, Boolean> keysPressed, int width, int height, int id){
        if (y + radius + speed <= height && keysPressed.get(Keys.S)) {
            y += speed;
        }
        if (y - speed >= height / 2 && keysPressed.get(Keys.Q)) {
            y -= speed;
        }
        if (x - speed >= 0 && keysPressed.get(Keys.A)) {
            x -= speed;
        }
        if (x + radius + speed <= width && keysPressed.get(Keys.W)) {
            x += speed;
        }

    }
}
