package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SBubbles {
    // An instance of a Sinking Bubble
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final int MAX_BUBBLES = 10;

    public Bubble bubble;
    private boolean isGameOver;

    /* Note to self: Each Bubble is an instance of Bubble
    that will either be true or false, and will be stored in
    a List of Bubbles
     */

    //EFFECTS: Creates empty list of bubbles
    public SBubbles(){
        bubble = new ArrayList<Bubble>();
        setUp();
    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_SPACE)
            bubble.move();
        else if (keyCode == KeyEvent.VK_R && isGameOver)
            setUp();
        else if (keyCode == KeyEvent.VK_X)
            System.exit(0);
        else
            bubbleControl(keyCode);
    }

    public boolean isOver() {
        return isGameOver;
    }

    public int getNumBubbles() {
        return bubble.size();
    }

    private void bubbleControl(int keyCode) {
        if (keyCode == KeyEvent.VK_B){
            Bubble.addBubble();
        }
        else if (keyCode == KeyEvent.VK_S){
            Bubble.addSolid();
        }
    }

    private void setUp() {
        bubble = new Bubble(WIDTH / 2);
        isGameOver = false;
    }
}
