package Zadania;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Layouty extends JFrame {
	
	private static final Dimension MIN_ROZMIAR_OKNA = new Dimension(300,200);
	private static final Dimension ROZMIAR_OKNA = new Dimension(600,400);
	
	private Container placeHolder = new JButton("Placeholder");
	private Container south = new JPanel();
	private JButton clear = new JButton("Clear");
	private JLabel status = new JLabel("Tu bedzie cos napisane");
	
	public Layouty() {
		super("Moje pierwsze okno");
		setSize(ROZMIAR_OKNA);
		setMinimumSize(MIN_ROZMIAR_OKNA);
		setLocationRelativeTo(null);

		Container ekran = getContentPane();
		ekran.setLayout(new BorderLayout());	
		
		ekran.add(placeHolder,BorderLayout.CENTER);
//		ekran.add(new JButton("WEST"),BorderLayout.WEST);
//		ekran.add(new JButton("EAST"),BorderLayout.EAST);
//		ekran.add(new JButton("NORTH"),BorderLayout.NORTH);
		ekran.add(south,BorderLayout.SOUTH);
		
		south.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		south.add(clear);
		south.add(status);
		
	}
	
	public static void main(String[] args) {
		Layouty okno = new Layouty();
		
		okno.setVisible(true);
	}

}
