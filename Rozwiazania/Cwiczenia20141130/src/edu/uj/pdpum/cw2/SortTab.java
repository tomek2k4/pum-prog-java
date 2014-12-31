package edu.uj.pdpum.cw2;

public class SortTab<E extends Comparable> extends NewTab<E> {
    @Override
    public void add(E wartosc) {
        super.add(wartosc);
        int ix = dlugosc - 1;
        while (ix > 0 && wartosc.compareTo(dane[ix - 1]) < 0 ) {
            dane[ix] = dane[ix - 1];
            ix--;
        }
        dane[ix] = wartosc;
        
    }
    
    @Override
    public void set(int i, E wartosc) {
        add(wartosc);
    }
    
    public void set(E wartosc) {
        add(wartosc);
    }
}
