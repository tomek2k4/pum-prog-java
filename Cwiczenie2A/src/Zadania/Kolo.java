package Zadania;

import java.awt.Color;
import java.awt.Graphics;

public class Kolo implements Shape {

    private final int x;
    private final int y;
    private final int w;
    private final int h;
    private final Color kolor;
    
    public Kolo(int x1, int y1, int x2, int y2, Color kolor) {
        this.x = (x1 < x2) ? x1 : x2 ;
        this.y = (y1 < y2) ? y1 : y2;
        this.w = Math.abs(x1 - x2);
        this.h = Math.abs(y1 - y2);
        this.kolor = kolor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(kolor);
        
        
        
        g.drawOval(x,y,w,h);
    }

}
