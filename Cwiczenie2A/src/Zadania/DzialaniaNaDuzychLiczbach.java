package Zadania;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DzialaniaNaDuzychLiczbach {
	
	public DzialaniaNaDuzychLiczbach() {
	}

	public String dodaj(String s){
	    String wynik= null;
		s.replaceAll("\\s+","");
		
		String [] liczby = s.split("\\+",2);
		System.out.println(Arrays.toString(liczby));	
		String [] liczbyArg1 = (liczby[0].split("")); 
		String [] liczbyArg2 = (liczby[1].split("")); 
		
		Integer [] liczbyIntArg1 = new Integer[liczbyArg1.length-1];
		Integer [] liczbyIntArg2 = new Integer[liczbyArg2.length-1];
		
		for(int i=0;i<liczbyIntArg1.length;i++){
			liczbyIntArg1[i] = Integer.parseInt(liczbyArg1[i+1]); 
		}
		
		for(int i=0;i<liczbyIntArg2.length;i++){
			liczbyIntArg2[i] = Integer.parseInt(liczbyArg2[i+1]); 
		}
		
		System.out.println(Arrays.toString(liczbyIntArg1));
		System.out.println(Arrays.toString(liczbyIntArg2));
		
		int dl = Math.max(liczbyIntArg1.length,liczbyIntArg2.length);
		
		while(warunek){
			
		}
		
		

		System.out.println(liczbyArg1[0]);
		
		return wynik;
	}
	
	
}
