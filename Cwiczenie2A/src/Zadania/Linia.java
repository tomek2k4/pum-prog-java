package Zadania;

import java.awt.Color;
import java.awt.Graphics;

public class Linia implements Shape {
	
	private final int x1;
	private final int y1;
	private final int x2;
	private final int y2;
	private final Color kolor;
	
	public Linia(int x1, int y1, int x2, int y2, Color kolor) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.kolor = kolor;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(kolor);
		g.drawLine(x1, y1, x2, y2);
		
	}

}
