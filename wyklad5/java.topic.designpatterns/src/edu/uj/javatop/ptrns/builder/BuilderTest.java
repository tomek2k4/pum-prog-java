package edu.uj.javatop.ptrns.builder;

public class BuilderTest {

	public static void main(String[] args) {
		Font.Builder fb = Font.builder();
		
		Font f = fb.name("Courier New").size(14).bold().noItalic().underline().build();
		Font f2 = fb.name("Console").build();
		
		System.out.println(f);

	}

}
