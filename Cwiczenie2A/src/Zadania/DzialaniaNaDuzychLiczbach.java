package Zadania;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DzialaniaNaDuzychLiczbach {
	
	public DzialaniaNaDuzychLiczbach() {
	}

	public String dodaj(String s){
		s = s.replaceAll("\\s+","");

		String [] liczby = s.split("\\+");
		System.out.println("Dodawane liczby: " + Arrays.toString(liczby));	
		

		int accum = 0;
		String a = liczby[0];
		String b = liczby[1];
		int aix = a.length() - 1;
		int bix = b.length() - 1;
		
		StringBuilder wynik = new StringBuilder();
		
		while( aix>=0 || bix >= 0){
			if(aix>=0){
				accum += a.charAt(aix) - '0';
				aix--;
			}
			if(bix>=0){
				accum += b.charAt(bix) - '0';
				bix--;
			}
			wynik.append(accum % 10);
			accum = accum / 10;
		}
		if(accum>0){
			wynik.append(accum);			
		}
		wynik.reverse();
		return wynik.toString();
	}
	
	
}
