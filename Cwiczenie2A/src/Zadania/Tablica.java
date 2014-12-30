package Zadania;

import java.util.Arrays;

public class Tablica {
	

	private static final double MAKSYMALNA_DLUGOSC = 15;
	private static final double MAKSYMALNA_WARTOSC = 101;
	protected int dlugosc;
	protected Integer[] tablica;
	
	public Tablica(){
		dlugosc = (int)(Math.random()*MAKSYMALNA_DLUGOSC);
		if (dlugosc < 3) dlugosc = 3;
		tablica = new Integer[dlugosc];
		
		for (int i=0;i<dlugosc;i++){
			tablica[i] = (int) (Math.random() * MAKSYMALNA_WARTOSC);
		}

		System.out.println("Dlugosc tablicy = " + dlugosc );
	}


	public int znajdzNajmniejzaRoznice(){
		
		int min_odl = 100;
		int porown_wart,roznica = 0;
		for (int i=0; i<dlugosc;i++){
			porown_wart = tablica[i];
			for (int j = i+1; j < tablica.length; j++) {
				roznica = Math.abs(tablica[i] - tablica[j]);
				if(roznica<min_odl) min_odl = roznica;
			}
		}
		return min_odl;
	}
	
	public int znajdzNajmniejzaRozniceSortowanie(){
		
		int min_odl = 100;
		int roznica = 0;
		Arrays.sort(tablica);

		return min_odl;
	}
	
	public boolean czyJestTrojkat(){
		Arrays.sort(tablica);
		return (tablica[0] + tablica[1] > tablica[dlugosc-1]);
	}
	
	
	
	@Override
	public String toString() {
		return Arrays.toString(tablica);
	}
	
	public int getDlugosc() {
		return dlugosc;
	}
}