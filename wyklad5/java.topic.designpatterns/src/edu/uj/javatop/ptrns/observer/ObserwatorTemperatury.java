package edu.uj.javatop.ptrns.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserwatorTemperatury implements Observer {

    @Override
    public void update(Observable src, Object argument) {
        
        CzujnikTemperatury ct = (CzujnikTemperatury) src;
        System.out.println(ct.temperatura);
        
        int t = (Integer) argument;
    }

}
