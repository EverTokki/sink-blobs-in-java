package model;

import java.awt.*;

public class Bubble {
/*    private List<Bubble> Bubble;
    // ListofBoolean where 1 means that it is a Bubble,
    // 0 means it is an empty Bubble*/

// Represents a bubble.

    public static final int DIAMETER = 15;
    public static final int DY = 15;
    public static final int X_POS = SBubbles.HEIGHT / 2;
    public static final Color COLOR = new Color(255, 255, 255);

    private int y;

    // EFFECT: Places bubble at position(X_POS, y)
    public Bubble(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    // EFFECT: Moves bubble
    public void move() {
        y = y - DY;
        handleBoundary();
    }

    //EFFECT: Makes sure the bubbles dont go below
    private void handleBoundary() {
        if (this.y <= SBubbles.HEIGHT) {
            this.y = SBubbles.HEIGHT;
        }
    }

    public static void addBubble() {

    }

    public static void addSolid() {
    }


    public static int size() {
        return Bubble.size();
    }

}
