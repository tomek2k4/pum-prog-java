package edu.uj.javatop.ptrns.factory;

import edu.uj.javatop.ptrns.factory.impl.SimpleWidgetFactory;

public class MainClass {

	public static void main(String[] args) {
		Application app = new Application(new SimpleWidgetFactory());
		
		app.startGUI();
		
		IButton pressIt = app.getWidgetFactory().createButton();

	}

}
