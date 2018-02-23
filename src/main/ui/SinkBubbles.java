package ui;

import model.SBubbles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class SinkBubbles extends JFrame {

    private static final int INTERVAL = 20;
    private SBubbles bubbles;
    private ActivePanel ap;

    //EFFECTS: sets up window in which the Bubbles will sink
    public SinkBubbles() {
        super("Sink Bubbles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        bubbles = new SBubbles();
        ap = new ActivePanel(bubbles);

        add(ap);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer(); //tick
    }

    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bubbles.update();
                ap.repaint();
            }
        });
        t.start();
    }

    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            bubbles.keyPressed(e.getKeyCode());
        }
    }

    public static void main(String[] args) {
        new SinkBubbles();
    }

}
