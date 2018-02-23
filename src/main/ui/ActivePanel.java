package ui;

import model.Bubble;
import model.SBubbles;

import javax.swing.*;
import java.awt.*;

public class ActivePanel extends JPanel {
    private SBubbles bubble;

    //sets backpanel
    public ActivePanel(SBubbles b) {
        setPreferredSize(new Dimension(SBubbles));
        setBackground(Color.GRAY);
        this.bubble = b;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawField(g);
    }

    //draws the game onto g
    private void drawField(Graphics g) {
        drawBubbles(g);
    }

    //Draws the tank onto g
    private void drawBubbles(Graphics g) {
        Bubble b = bubble.getBubble();
        Color savedCol = g.getColor();
        g.setColor(Bubble.COLOR);
        g.fillOval(b.X_POS, b.getY(), b.DIAMETER, b.DIAMETER);
        g.setColor(savedCol);
    }

    // EFFECTS:  centres the string str horizontally onto g at vertical position yPos
    private void centreString(String str, Graphics g, FontMetrics fm, int yPos) {
        int width = fm.stringWidth(str);
        g.drawString(str, (SBubbles.WIDTH - width) / 2, yPos);
    }
}
