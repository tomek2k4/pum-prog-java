package Zadania;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CzytaniePliku {
	
	Collection<String> col;
	
	public static void main(String[] args) {
		
		CzytaniePliku cz = new CzytaniePliku();
		cz.wczytaj();
		
	}
	
	
	public  void wczytaj(){
		
		col = new HashSet<String>();
		FileReader wePlik;
		String temp;
		
		try {
			wePlik = new FileReader("C:\\Temp\\input.txt");
			BufferedReader strumien = new BufferedReader(wePlik);
			String lc = null;
			
			temp = strumien.readLine();
			while(temp!=null){
				lc = temp.toLowerCase();
				if(!col.contains(lc)){
					col.add(lc);
				}
				temp = strumien.readLine();
			}
			
			for (String s : col){
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
