package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pelota extends JPanel implements ActionListener {
    private int x = 0;
    private int y = 50;
    private Timer timer;

    public Pelota() {
        timer = new Timer(50, this);  // Timer that fires every 10 milliseconds
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);  // Draw a red circle
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;  // Move the object to the right
        if (x > getWidth()) {
            x = 0;  // Reset to the left if it goes off screen
        }
        repaint();  // Request a repaint of the panel
    }
}