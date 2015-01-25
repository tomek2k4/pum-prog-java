package Zadania;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Rot {
	
	static String plikWe = "C:\\Temp\\";
	static String plikWy = "C:\\Temp\\";
	
	public static void main(String[] args) {
		plikWe = "C:\\Temp\\one.txt";
		plikWy = "C:\\Temp\\two2.txt";
		boolean code = true;
		
		if (args.length>1) {
			plikWe = plikWe.concat(args[1]);
			plikWy = plikWe.concat(args[2]);
			
			if(args[3].equals("C")){
				code = true;
			}else if(args[3].equals("D")){
				code = false;
			}else{
				System.out.println("Wrong last parameter");
			}
			
		}
		System.out.println("Plik Wejsciowy: "+ plikWe);
		System.out.println("Plik Wyjsciowy: "+ plikWy);
		System.out.println("Kodowanie="+code);
		
		koduj_dekoduj(code);
		
	}
	
	public static void koduj_dekoduj(boolean koduj){
		try {
			FileInputStream strWe = new FileInputStream(plikWe);
			FileOutputStream strWy = new FileOutputStream(plikWy);
			
			int znak = strWe.read();
			while(znak != -1){
				if(koduj){
					strWy.write((char)znak+13);					
				}else{
					strWy.write((char)znak-13);
				}
				znak = strWe.read();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
