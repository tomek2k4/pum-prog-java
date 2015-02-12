package edu.uj.javatop.ptrns.observer;

import java.util.Observable;

public class CzujnikTemperatury extends Observable {

    public int temperatura;
    
    private void zmianaTemperatury() {
        setChanged();
        notifyObservers(new Integer(temperatura));
        clearChanged();
    }
    
}
