package Zadania;

public class OsmiuHetmanow {
	
	private int MAKS_LICZBA_HETMANOW = 8;
	private boolean[][] szachownica;
	private int liczbaUstawHetmanow;
	
	public void stworz(int wymiar){
		
		MAKS_LICZBA_HETMANOW = wymiar;
		szachownica = new boolean[wymiar][wymiar];
		for (int i = 0; i < szachownica.length; i++) {
			for (int j = 0; j < szachownica[0].length; j++) {
				szachownica[i][j] = false;
			}
		}
		liczbaUstawHetmanow = 0;
		ustawHetmanow();
		
	}

	private void ustawHetmanow(){
		boolean ret;
		ret = ustawHetmana(0,0,0);
	
		if(ret){
			System.out.println("Udalo sie rozwiazc problem");
		}else{
			System.out.println("Nie udalo sie rozwiazac problemu");
		}
	}

	private boolean ustawHetmana(int i, int j,int zagl) {
		System.out.println("Pozycja x: "+i+",Pozycja y:"+j+",Zaglebienie: "+zagl);

		if(liczbaUstawHetmanow==MAKS_LICZBA_HETMANOW ){
			System.out.println("Wszyscy hetmani sa ustawieni");
			System.out.println("Kombinacja:");
			System.out.println(this);
			return true;
		}
		
		if(i>MAKS_LICZBA_HETMANOW-1){
			System.out.println("Przekroczona lista wierszy");
			return false;
		}
		
		if (j>MAKS_LICZBA_HETMANOW-1){
			System.out.println("Przekroczona lista kolumn");
			return false;
		}
			
		if(sprawdzHetmana(i,j)){
			szachownica[i][j] = true;
			liczbaUstawHetmanow++;
			//ustaw hetmana w kolejnej linijce
			System.out.println("Ustaw hetmana w kolejnej linijce");
			return ustawHetmana(i+1, 0, zagl+1);
		}else{
			//ustaw hetmana w kolejnej kolumnie tej samej linijki
			return ustawHetmana(i, j+1, zagl+1);
		}
	}

	private boolean sprawdzHetmana(int i, int j) {
		boolean ret = true;

		if (szachownica[i][j] == true ){
			//Hetman jest juz w tym miesjcu
			System.out.println("Hetman jest juz w tym miesjcu");
			return false;
		}
		//Sprawdz linijki
		for (int i2 = 0; i2 < i; i2++) {
			if(szachownica[i2][j] == true){
				//jest juz hetman w tej kolumnie
				System.out.println("jest juz hetman w tej kolumnie");
				return false;
			}
		}
		int i2 = i-1;
		int j2 = j-1;
		//sprawdz po skosie w lewo
		while( i2>=0 && j2>=0){
			if(szachownica[i2][j2] == true){
				System.out.println("Hetman jest ustawiony po skosie w lewo");
				return false;
			}
			i2--;
			j2--;
		}
		
		i2 = i-1;
		j2 = j+1;
		//sprawdz po skosie w prawo
		while( i2>=0 && j2<MAKS_LICZBA_HETMANOW){
			if(szachownica[i2][j2] == true){
				System.out.println("Hetman jest ustawiony po skosie w prawo");
				return false;
			}
			i2--;
			j2++;
		}


		return ret;
	}
	
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < szachownica[0].length; i++) {
			for (int j = 0; j < szachownica.length; j++) {
				if(szachownica[i][j]==true){
					str.append('H');
				}else{
					str.append('*');
				}
			}
			str.append('\n');
		}
		
		return str.toString();
	}

}
