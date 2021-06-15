package model;

import java.util.HashMap;

public class Model {
    Ball ball;
    Player player1;
    Player player2;
    HashMap<Keys, Boolean> keysPressed;
    GameState state;
    public Model(){
        ball = new Ball(300, 400);
        player1 = new Player(1);
        player2 = new Player( 2);
        keysPressed = new HashMap<Keys, Boolean>();
        setKeysPressed();
        state = GameState.PLAYING;

    }

    public void move(int width, int height){
        if (state == GameState.PLAYING) {
            ball.move(width, height, isCollapsed(player1.getStrikerX(), player1.getStrikerY(), player1.getStrikerRadius()) || isCollapsed(player2.getStrikerX(), player2.getStrikerY(), player2.getStrikerRadius()));
            player1.moveStriker(keysPressed, width, height);
            player2.moveStriker(keysPressed, width, height);
        }
        changeGameState();
    }

    private void changeGameState(){
        System.out.println(getBallY());
        if (getBallY() <= 3){
            state = GameState.SECOND_WON;
        }
        if (getBallY() >= 703){
            state = GameState.FIRST_WON;
        }
        if (state != GameState.PLAYING && keysPressed.get(Keys.ENTER)){
            state = GameState.PLAYING;
        }
    }

    private boolean isCollapsed(int X, int Y, int radius){
        int strX = X - radius / 2;
        int strY = Y - radius / 2;
        int ballX = getBallX() - getBallRadius();
        int ballY = getBallY() - getBallRadius();
       if (((strX - ballX)*(strX - ballX) + (strY - ballY)*(strY - ballY)) <= (radius / 2 + getBallRadius() / 2)*(radius / 2 + getBallRadius() / 2)){
            return true;
        }
        return false;
    }

    public int getBallX(){
        return ball.getX();
    }

    public int getBallY(){
        return ball.getY();
    }

    public int getBallRadius(){
        return ball.getRadius();
    }

    private void setKeysPressed(){
        for (Keys key : Keys.values()){
            keysPressed.put(key, false);
        }
    }

    public void setKey(Keys key, boolean isPressed){
        keysPressed.put(key, isPressed);
    }

    public int getStrikerX(int id){
        if (id == 1)
            return player1.getStrikerX();
        else
            return player2.getStrikerX();
    }

    public int getStrikerY(int id){
        if (id == 1)
            return player1.getStrikerY();
        else
            return player2.getStrikerY();
    }

    public GameState returnState(){
        return state;
    }



}
