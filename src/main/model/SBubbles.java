package model;

import java.util.ArrayList;
import java.util.List;

public class SBubbles {
    // An instance of a Sinking Bubble
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final int MAX_BUBBLES = 10;


    private List<bubble> bubble;
    // ListofBoolean where 1 means that it is a bubble,
    // 0 means it is an empty bubble

    //EFFECTS: Creates empty list of bubbles
    public SBubbles(){
        bubble = new ArrayList(bubble);
        setUp();
    }

    //EFFECTS: Updates bubbles
    public void update(){
        bubble.move();

    }

    private void setUp() {
    }
}
