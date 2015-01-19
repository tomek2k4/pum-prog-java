package edu.uj.pdpum.rysowanie;
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


public class Rysowanie2 extends JFrame {

    private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(350, 200);
    private static final Dimension ROZMIAR_OKNA = new Dimension(600, 400);

    private ShapePanel placeholder = new ShapePanel();
    private Container south = new JPanel();
    private JButton clear = new JButton("Clear");
    private JLabel status = new JLabel("Tu bedzie cos napisane.");
    
    public Rysowanie2() {
        super("Rysowania - wersja dobra");
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
        Rysowanie2 okno = new Rysowanie2();

        okno.setVisible(true);
    }
    
    private class MyMouseListener extends MouseAdapter {
        
        private boolean lastLine = false;

        private int startX;
        private int startY;

        @Override
        public void mousePressed(MouseEvent e) {
            startX = e.getX();
            startY = e.getY();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Shape l = null;
            if (lastLine) {
                l = new Prostokat(startX, startY, e.getX(), e.getY(), Color.GREEN);
            } else {
                l = new Linia(startX, startY, e.getX(), e.getY(), Color.BLUE);
            }
            lastLine = !lastLine;
            placeholder.add(l);
        }
        
    }
}
