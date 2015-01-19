public class SystemyPozycyjne {

    public static final char[] CYFRY = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
            'D', 'E', 'F' };

    public static void main(String[] args) {
        long liczba = -15879199808L;
        
        System.out.println("(10): " + liczba);
        System.out.println("(2): " + dec2other(liczba, 2));
        System.out.println("(4): " + dec2other(liczba, 4));
        System.out.println("(8): " + dec2other(liczba, 8));
        System.out.println("(16): " + dec2other(liczba, 16));
        System.out.println("(3): " + dec2other(liczba, 3));
        System.out.println("(9): " + dec2other(liczba, 9));
        System.out.println("(27): " + dec2other(liczba, 27));
    }

    public static String dec2other(long n, int podstawa) {
        if (podstawa < 2 || podstawa > 30) {
            throw new IllegalArgumentException("Nipoprawna podstawa systemu: " + podstawa);
        }
        if (n == 0) {
            return "0";
        }
        
        String sgn = "";
        if (n < 0) {
            sgn = "-";
            n = -n;
        }
        
        StringBuilder res = new StringBuilder("");
        while (n > 0) {
            int cyfra = (int) (n % podstawa);
            res.insert(0, symbolCyfry(cyfra, podstawa));
            n /= podstawa; // n = n / podstawa;
        }
        res.insert(0, sgn);
       
        return res.toString();
    }
    
    private static String symbolCyfry(int wartosc, int podstawa) {
        if (wartosc < 10) {
            return Character.toString((char) ('0' + wartosc));
        } else {
            //return "[" + wartosc + "]";
            return Character.toString((char) ('A' + wartosc - 10));
        }
    }

}
