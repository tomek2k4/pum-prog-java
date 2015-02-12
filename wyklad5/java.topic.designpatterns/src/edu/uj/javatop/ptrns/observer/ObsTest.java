package edu.uj.javatop.ptrns.observer;

public class ObsTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ObserwatorTemperatury ot1 = new ObserwatorTemperatury();
        ObserwatorTemperatury ot2 = new ObserwatorTemperatury();
        
        CzujnikTemperatury czujnik = new CzujnikTemperatury();
        
        czujnik.addObserver(ot1);
        czujnik.addObserver(ot2);

    }

}
