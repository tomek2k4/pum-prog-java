import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ZdarzeniaMyszki extends JFrame {

    private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(350, 200);
    private static final Dimension ROZMIAR_OKNA = new Dimension(600, 400);

    private Container placeholder = new JPanel();
    private Container south = new JPanel();
    private JButton clear = new JButton("Clear");
    private JLabel status = new JLabel("Tu bedzie cos napisane.");
    
    public ZdarzeniaMyszki() {
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
        ZdarzeniaMyszki okno = new ZdarzeniaMyszki();

        okno.setVisible(true);
    }
    
    private class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            status.setText("Clicked: x=" + e.getX() + ", y=" + e.getY());
            
            float x = e.getX();
            x = x / placeholder.getWidth();
            
            placeholder.setBackground(new Color(x, x, x, 1.0f));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            status.setText("Entered: x=" + e.getX() + ", y=" + e.getY());
        }

        @Override
        public void mouseExited(MouseEvent e) {
            status.setText("Exited: x=" + e.getX() + ", y=" + e.getY());
        }

        @Override
        public void mousePressed(MouseEvent e) {
            status.setText("Pressed: x=" + e.getX() + ", y=" + e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            status.setText("Released: x=" + e.getX() + ", y=" + e.getY());
        }
        
    }
}
