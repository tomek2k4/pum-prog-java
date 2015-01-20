package Zadania;

public class ZamianaSystemowLiczbowych {
	
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
	
	public static String dec2other(long n,int podstawa){
		return null;
		
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
