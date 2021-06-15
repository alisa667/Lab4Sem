package model;

public class Ball {
    private int x, y;
    private int angleX, angleY;
    private final int speed = 3;
    private final int radius = 50;
    Ball(int xInit, int yInit){
        x = xInit;
        y = yInit;
        angleX = speed;
        angleY = speed;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public int getRadius(){
        return radius;
    }

    public void move(int width, int height, boolean isCollapsed){
         if (isCollapsed){
             angleX = -angleX;
             angleY = -angleY;
         }
         if (x + angleX < 0) {
             angleX = speed;
         }
         if (x + angleX > width - radius){
             angleX = -speed;
         }
         if (y + angleY < 0) {
            angleY = speed;
         }
         if (y + angleY > height - radius){
             angleY = -speed;
         }
         x += angleX;
         y += angleY;

    }

}
