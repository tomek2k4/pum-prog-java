package edu.uj.pdpum.cw2;

public class Ulamek {
    public static final Ulamek ZERO = new Ulamek(0);
    public static final Ulamek JEDEN = new Ulamek(1);
    
    
    private final int licznik;
    private final int mianownik;

    public Ulamek(int l, int m) {
        if (m != 0) {
            int sgn = 1;
            if (l < 0) {
                l = -l;
                sgn = -sgn;
            }
            if (m < 0) {
                m = -m;
                sgn = -sgn;
            }
            int nwd = nwd(l, m);
            licznik = sgn * l / nwd;
            mianownik = m / nwd;
        } else {
            throw new IllegalArgumentException("Mianownik rowny zero.");
        }
    }

    public Ulamek(int liczba) {
        this(liczba, 1);
    }
    
    public Ulamek dodaj(Ulamek r) {
        int licz = this.licznik * r.mianownik + this.mianownik * r.licznik;
        int mian = this.mianownik * r.mianownik;
        
        return new Ulamek(licz, mian);
    }
    
    public Ulamek odejmij(Ulamek r) {
        int licz = this.licznik * r.mianownik - this.mianownik * r.licznik;
        int mian = this.mianownik * r.mianownik;
        
        return new Ulamek(licz, mian);
    }
    
    public Ulamek pomnoz(Ulamek r) {
        int licz = this.licznik * r.licznik;
        int mian = this.mianownik * r.mianownik;
        
        return new Ulamek(licz, mian);
    }
    
    public Ulamek podziel(Ulamek r) {
        int licz = this.licznik * r.mianownik;
        int mian = this.mianownik * r.licznik;
        
        if (mian == 0) {
            throw new ArithmeticException("Dzielenie przez zero.");
        }
        
        return new Ulamek(licz, mian);
    }
    
    public double doubleValue() {
        return ((double) licznik) / mianownik;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ulamek) {
            Ulamek u = (Ulamek) obj;
            return (u.licznik == this.licznik) && (u.mianownik == this.mianownik);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" + licznik + "/" + mianownik + "}";
    }

    private static int nwd(int a, int b) {
        while (a * b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a + b;
    }

    // private static int nwd(int a, int b) {
    // if (a * b == 0) {
    // return a + b;
    // } else {
    // return nwd(b, a % b);
    // }
    // }
}
