import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Rysowanie extends JFrame {

    private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(350, 200);
    private static final Dimension ROZMIAR_OKNA = new Dimension(600, 400);

    private Container placeholder = new JPanel();
    private Container south = new JPanel();
    private JButton clear = new JButton("Clear");
    private JLabel status = new JLabel("Tu bedzie cos napisane.");
    
    public Rysowanie() {
        super("MouseListener");
        setSize(ROZMIAR_OKNA);
        setMinimumSize(MIN_ROZMIAR_OKNA);
        setLocationRelativeTo(null);

        Container ekran = getContentPane();
        ekran.setLayout(new BorderLayout());
        
        ekran.add(placeholder, BorderLayout.CENTER);
        ekran.add(south, BorderLayout.SOUTH);
        
        south.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        south.add(clear);
        south.add(status);
        
        placeholder.addMouseListener(new MyMouseListener());
        
    }

    public static void main(String[] args) {
        Rysowanie okno = new Rysowanie();

        okno.setVisible(true);
    }
    
    private class MyMouseListener extends MouseAdapter {

        private int startX;
        private int startY;

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Graphics g = placeholder.getGraphics();
            g.setColor(Color.BLUE);
            g.drawLine(startX, startY, e.getX(), e.getY());
        }
        
    }
}
