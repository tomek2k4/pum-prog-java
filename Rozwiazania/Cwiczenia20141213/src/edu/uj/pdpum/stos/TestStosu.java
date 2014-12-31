package edu.uj.pdpum.stos;

public class TestStosu {

    public static void main(String[] args) {
        Stos s = new Stos();

        s.push(3);
        s.push(11);
        s.push(7);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        
        s.pop();

    }

}
