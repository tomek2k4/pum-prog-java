package edu.uj.pdpum.cw2;

public class Test {

    public static void main(String[] args) {
        Ulamek a = new Ulamek(1, 3);
        Ulamek b = new Ulamek(2, -8);

        System.out.println(a);
        System.out.println(b);
        System.out.println(a.dodaj(b));
        System.out.println(a.dodaj(Ulamek.JEDEN));
        System.out.println(a.odejmij(b));
        System.out.println(a.pomnoz(b));
        System.out.println(a.podziel(b));
        
        System.out.println(a.equals(b));
        System.out.println(a.equals(new Ulamek(2, 6)));

        System.out.println(b.doubleValue());
        
        System.out.println(a.podziel(Ulamek.ZERO));

    }

}
