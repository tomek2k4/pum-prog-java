package edu.uj.pdpum.rysowanie;

import java.awt.Color;
import java.awt.Graphics;

public class Prostokat implements Shape {

    private final int x;
    private final int y;
    private final int w;
    private final int h;
    private final Color kolor;
    
    public Prostokat(int x1, int y1, int x2, int y2, Color kolor) {
        this.x = (x1 < x2) ? x1 : x2 ;
        this.y = (y1 < y2) ? y1 : y2;
        this.w = Math.abs(x1 - x2);
        this.h = Math.abs(y1 - y2);
        this.kolor = kolor;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(kolor);
        g.drawRoundRect(x, y, w, h, 8, 8);
    }

}
