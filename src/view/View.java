package view;

import model.GameState;
import model.Keys;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Thread.sleep;

public class View extends JPanel {
    JFrame frame;
    Model model;
    public View(){
        model = new Model();
        frame = new JFrame("Air Hockey");
        frame.setContentPane(this);
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.PINK);
        frame.setVisible(true);
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        model.setKey(Keys.DOWN, true);
                        break;
                    case KeyEvent.VK_UP:
                        model.setKey(Keys.UP, true);
                        break;
                    case KeyEvent.VK_LEFT:
                        model.setKey(Keys.LEFT, true);
                        break;
                    case KeyEvent.VK_RIGHT:
                        model.setKey(Keys.RIGHT, true);
                        break;
                    case KeyEvent.VK_S:
                        model.setKey(Keys.S, true);
                        break;
                    case KeyEvent.VK_A:
                        model.setKey(Keys.A, true);
                        break;
                    case KeyEvent.VK_W:
                        model.setKey(Keys.W, true);
                        break;
                    case KeyEvent.VK_Q:
                        model.setKey(Keys.Q, true);
                        break;
                    case KeyEvent.VK_ENTER:
                        model.setKey(Keys.ENTER, true);
                        break;
                    default:
                        break;
                }
            }

            public void keyReleased(KeyEvent e){
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        model.setKey(Keys.DOWN, false);
                        break;
                    case KeyEvent.VK_UP:
                        model.setKey(Keys.UP, false);
                        break;
                    case KeyEvent.VK_LEFT:
                        model.setKey(Keys.LEFT, false);
                        break;
                    case KeyEvent.VK_RIGHT:
                        model.setKey(Keys.RIGHT, false);
                        break;
                    case KeyEvent.VK_S:
                        model.setKey(Keys.S, false);
                        break;
                    case KeyEvent.VK_A:
                        model.setKey(Keys.A, false);
                        break;
                    case KeyEvent.VK_W:
                        model.setKey(Keys.W, false);
                        break;
                    case KeyEvent.VK_Q:
                        model.setKey(Keys.Q, false);
                        break;
                    case KeyEvent.VK_ENTER:
                        model.setKey(Keys.ENTER, false);
                        break;
                    default:
                        break;
                }
            }
        });

    }
    @Override
    public void paint (Graphics graphics){
        super.paint(graphics);
        switch(model.returnState()){
            case PLAYING:
                graphics.setColor(Color.BLUE);
                graphics.fillOval(model.getBallX(), model.getBallY(), model.getBallRadius(), model.getBallRadius());
                graphics.setColor(Color.RED);
                graphics.fillOval(model.getStrikerX(1), model.getStrikerY(1), 60, 60);
                graphics.fillOval(model.getStrikerX(2), model.getStrikerY(2), 60, 60);
                break;
            case FIRST_WON:
                graphics.drawString("PLAYER1 WON! PRESS ENTER TO PLAY AGAIN", 200, getHeight() / 2);
                break;
            case SECOND_WON:
                graphics.drawString("PLAYER2 WON! PRESS ENTER TO PLAY AGAIN", 200, getHeight() / 2);
                break;
            default:
                break;
        }

    }

    public void draw() throws InterruptedException {
        while (true){
            model.move(getWidth(), getHeight());
            repaint();
            Thread.sleep(10);
        }
    }


}
