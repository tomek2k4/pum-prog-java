package edu.uj.pdpum.rysowanie;
import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.JPanel;


public class ShapePanel extends JPanel {
    
    private final Collection<Shape> ksztalty = new LinkedList<Shape>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        for (Shape s : ksztalty) {
            s.draw(g);
        }
    }
    
    public void add(Shape s) {
        ksztalty.add(s);
        repaint();
    }
    
    public void remove(Shape s) {
        ksztalty.remove(s);
        repaint();
    }
    
    public void clear() {
        ksztalty.clear();
        repaint();
    }
}
