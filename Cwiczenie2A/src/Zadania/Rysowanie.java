package Zadania;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Rysowanie extends JFrame {
	
	private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(300,200);
	private static final int WINDOW_SIZE_X = 600;
	private static final int WINDOW_SIZE_Y = 400;
	private static final Dimension ROZMIAR_OKNA = new Dimension(WINDOW_SIZE_X,WINDOW_SIZE_Y);
	
	private ShapePanel placeHolder = new ShapePanel();
	private Container south = new JPanel();
	private JButton clear = new JButton("Clear");
	private JLabel status = new JLabel("Tu bedzie cos napisane");
	
	public Rysowanie() {
		super("MouseListener");
		setSize(ROZMIAR_OKNA);
		setMinimumSize(MIN_ROZMIAR_OKNA);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container ekran = getContentPane();
		ekran.setLayout(new BorderLayout());	
		
		ekran.add(placeHolder,BorderLayout.CENTER);
		ekran.add(south,BorderLayout.SOUTH);
		
		south.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		south.add(clear);
		south.add(status);
		
		placeHolder.addMouseListener(new MyMouseListener());
	}
	
	private class MyMouseListener extends MouseAdapter{

		private int startX;
		private int startY;
		
		private boolean lastLine = false;
		
		@Override
		public void mousePressed(MouseEvent e) {
			startX = e.getX();
			startY = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
            Shape l = null;
//            if (lastLine) {
//                l = new Prostokat(startX, startY, e.getX(), e.getY(), Color.GREEN);
//            } else {
//                l = new Linia(startX, startY, e.getX(), e.getY(), Color.BLUE);
//            }
//            lastLine = !lastLine;
            
            l = new Kolo(startX, startY, e.getX(), e.getY(), Color.BLUE);
            placeHolder.add(l);

		}
		
	}
	
	
	
	public static void main(String[] args) {
		Rysowanie okno = new Rysowanie();
		
		okno.setVisible(true);
	}

}
