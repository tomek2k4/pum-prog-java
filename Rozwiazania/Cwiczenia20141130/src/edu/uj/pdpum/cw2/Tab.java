package edu.uj.pdpum.cw2;


public class Tab<E> {
    protected static final int ROZMIAR_POCZATKOWY = 3;
    protected static final double WSPOLCZYNNIK_WYPELNIENIA = 0.25;

    protected int dlugosc = 0;
    protected Object[] dane = new Object[ROZMIAR_POCZATKOWY];

    public E get(int i) {
        if (i < 0 || i >= dlugosc) {
            throw new ArrayIndexOutOfBoundsException("Niepoprawny indeks: " + i);
        }
        return (E) dane[i];
    }

    public void set(int i, E wartosc) {
        if (i < 0 || i >= dlugosc) {
            throw new ArrayIndexOutOfBoundsException("Niepoprawny indeks: " + i);
        }
        dane[i] = wartosc;
    }

    public void add(E wartosc) {
        if (dlugosc == dane.length) {
            zmienRozmiarTablicy(dane.length * 2);
        }
        dane[dlugosc++] = wartosc;
    }

    public E trim() {
        if (dlugosc > 0) {
            dlugosc--;
            E ret = (E) dane[dlugosc];
            dane[dlugosc] = null;

            if ((double) dlugosc <= dane.length * WSPOLCZYNNIK_WYPELNIENIA) {
                zmienRozmiarTablicy(dane.length / 2);
            }
            return ret;
        } else {
            return null;
        }
    }
    
    public int size() {
        return dlugosc;
    }

    private void zmienRozmiarTablicy(int nowyRozmiar) {
        Object[] noweDane = new Object[nowyRozmiar];
        for (int i = 0; i < dane.length; i++) {
            noweDane[i] = dane[i];
        }
        dane = noweDane;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("[");
        for (int i = 0; i < dlugosc; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            buffer.append(dane[i].toString());
        }
        buffer.append("]");
        return buffer.toString();
    }

}
