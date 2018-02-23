package model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/*
TODO: Drawing each bubble or blob on the field
TODO: Every time blob is added, needs to be placed on y + DY
TODO: As time ticks (SPACEBAR), the blob should sink to the floor
TODO: Helper function that SINKS the blob
TODO: The DRAWING function should rely on the ListOfBlobs ONLY and render it
TODO: (This means that it should be rendering blobs/bubbles each 20 pixels, depending on the array of Bubbles)
TODO: Every time the "s" or "b" is pressed, 1. should add it to ListOfBlobs 2. should render it.
Relevant racket code
(define (sink lob)
  (cond [(empty? lob) empty]
        [else
         (sink-one (first lob)(sink (rest lob)))]))

this defines the ListOfBlobs

TODO: Rethink how everything works. I need Bubbles and Solids, and a list of them, and a class to render them all (ActivePanel)
 */

public class SBubbles {
    // An instance of a Sinking Bubble
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final int MAX_BUBBLES = 10;

    public Bubble bubble;
    public Solid solid;
    private boolean isGameOver;
    private List<Bubble> bubbles;

    /* Note to self: Each Bubble is an instance of Bubble
    that will either be true or false, and will be stored in
    a List of Bubbles
     */

    //EFFECTS: Creates empty list of bubbles
    public SBubbles() {
        bubbles = new ArrayList<Bubble>();
        setUp();
    }

    //Updates the state of the bubble every tick
    public void update() {
        bubble.move();
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

    public Bubble getBubble() {
        return bubble;
    }

    private void bubbleControl(int keyCode) {
        if (keyCode == KeyEvent.VK_B) {
            if (bubbles.size() < MAX_BUBBLES) {
                bubbles.add(bubble);
            }
        }
        else if (keyCode == KeyEvent.VK_S) {
            if (bubbles.size() < MAX_BUBBLES) {
                bubbles.add(solid);
            }
        }
    }

    private void setUp() {
        bubble = new Bubble(WIDTH / 2);
        isGameOver = false;
    }
}
