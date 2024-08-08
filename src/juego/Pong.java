package juego;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

public class Pong {

    private JFrame frame;
    JPanel BarraIzq = new JPanel();
    JPanel BarraDer = new JPanel();
    Pelota pelota = new Pelota();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pong window = new Pong();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pong() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 800, 520);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
		frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        BarraIzq.setBackground(Color.WHITE);

        BarraIzq.setBounds(20, 211, 10, 70);
        frame.getContentPane().add(BarraIzq);
        BarraDer.setBackground(Color.WHITE);

        BarraDer.setBounds(755, 211, 10, 70);
        frame.getContentPane().add(BarraDer);
        
        Pelota pelota_1 = new Pelota();
        pelota_1.setBounds(385, 246, 10, 10);
        frame.getContentPane().add(pelota_1);

        int borderThickness = 2;
        Color borderColor = Color.GRAY;
        Border border = BorderFactory.createMatteBorder(borderThickness, 0, 0, 0, borderColor);

        
        
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    if (BarraIzq.getY() > 12) {
                        int y = BarraIzq.getY();
                        y -= 20;
                        BarraIzq.setBounds(20, y, 10, 70);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    if (BarraIzq.getY() < 520 - 170) {
                        int y = BarraIzq.getY();
                        y += 20;
                        BarraIzq.setBounds(20, y, 10, 70);
                    }
                }
        }});
    }
}
