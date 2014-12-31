package Zadania;

import java.util.Scanner;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.print("Podaj wyrazenie: ");
        Scanner input = new Scanner(System.in);
        String wyr = "7324890172349817239846187236487123648173640132471115 + 897821347102348712309487123984765631612934612836481723648712328";
        wyr = input.nextLine();
		DzialaniaNaDuzychLiczbach dzialania = new DzialaniaNaDuzychLiczbach();
		System.out.println("Wynik: " + dzialania.dodaj(wyr));
		
		input.close();
	}

}
