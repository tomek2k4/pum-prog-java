package Zadania;

public class Ulamek {

	private final int licznik;
	private final int mianownik;

	public Ulamek(int l, int m) {
		if (m != 0) {
			int sgn = 1;
			if (l<0) {
				l = -l;
				sgn = -sgn;
			} 
			if (m<0) {
				m = -m;
				sgn = -sgn;
			}
			
			int nwd = NWD(l, m);
			licznik = sgn*(l / nwd);
			mianownik = m / nwd;
		} else {
			throw new IllegalArgumentException("Mianownik rowny zero.");
		}
	}

	public Ulamek(int l) {
		this(l,1);
	}

	@Override
	public String toString() {
		return "{" + licznik + "," + mianownik + "}";
	}

	private int NWD(int a, int b) {
		while (a * b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a + b;
	}

	public Ulamek dodaj(Ulamek b) {
		int licz = this.licznik * b.mianownik + b.licznik*this.mianownik;
		int mian = this.mianownik * b.mianownik;
		return new Ulamek(licz,mian);
	}
	
	public Ulamek odejmij(Ulamek b) {
		Ulamek tmpUlamek = new Ulamek(-b.getLicznik(),b.getMianownik());
		return this.dodaj(tmpUlamek);
	}
	
	public Ulamek pomnoz(Ulamek b) {
		int licz = this.licznik * b.licznik;
		int mian = this.mianownik * b.mianownik;
		
		return new Ulamek(licz,mian);
	}
	
	public Ulamek podziel(Ulamek b) {
		int licz = this.licznik * b.mianownik;
		int mian = this.mianownik * b.licznik;
		
		return new Ulamek(licz,mian);
	}
	
	public double doubleValue() {
		return (double)this.licznik/(double)this.mianownik;
	}
	
	public boolean equals(Ulamek b) {
		if(this.licznik == b.getLicznik() && this.mianownik == b.getMianownik()){
			return true;
		}else{
			return false;
		}

	}
	
	// private static int NWD(int a,int b){
	// if (a*b == 0) {
	// return a+b;
	// }else{
	// return NWD(b,a%b);
	// }
	//
	// }

	public int getLicznik() {
		return licznik;
	}
	
	public int getMianownik() {
		return mianownik;
	}
}
