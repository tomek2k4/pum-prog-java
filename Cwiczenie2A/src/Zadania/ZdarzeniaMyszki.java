package Zadania;

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
	
	private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(300,200);
	private static final int WINDOW_SIZE_X = 600;
	private static final int WINDOW_SIZE_Y = 400;
	private static final Dimension ROZMIAR_OKNA = new Dimension(WINDOW_SIZE_X,WINDOW_SIZE_Y);
	
	private Container placeHolder = new JPanel();
	private Container south = new JPanel();
	private JButton clear = new JButton("Clear");
	private JLabel status = new JLabel("Tu bedzie cos napisane");
	
	public ZdarzeniaMyszki() {
		super("MouseListener");
		setSize(ROZMIAR_OKNA);
		setMinimumSize(MIN_ROZMIAR_OKNA);
		setLocationRelativeTo(null);

		Container ekran = getContentPane();
		ekran.setLayout(new BorderLayout());	
		
		ekran.add(placeHolder,BorderLayout.CENTER);
		ekran.add(south,BorderLayout.SOUTH);
		
		south.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		south.add(clear);
		south.add(status);
		
		placeHolder.addMouseListener(new MyMouseListener());
	}
	
	private class MyMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
		    float pointX = e.getX();
		    float scaledPointX = 1 - pointX/WINDOW_SIZE_X;
		    status.setText("Clicked: x="+pointX+", y="+e.getY());
			placeHolder.setBackground(new Color(scaledPointX,scaledPointX,scaledPointX)); 
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			status.setText("Entered: x="+e.getX()+", y="+e.getY());
		}

		@Override
		public void mouseExited(MouseEvent e) {
			status.setText("Exited: x="+e.getX()+", y="+e.getY());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			status.setText("Pressed: x="+e.getX()+", y="+e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			status.setText("Released: x="+e.getX()+", y="+e.getY());
		}
		
	}
	
	
	
	public static void main(String[] args) {
		ZdarzeniaMyszki okno = new ZdarzeniaMyszki();
		
		okno.setVisible(true);
	}

}
