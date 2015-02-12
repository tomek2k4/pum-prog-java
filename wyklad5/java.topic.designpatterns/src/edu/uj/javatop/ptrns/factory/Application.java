package edu.uj.javatop.ptrns.factory;

/**
 * Klasa glowna aplikacji.
 * Pozwala ona zarowno na dostep do fabryk obiektow jak i wykonywania aktywnosci glownych.
 *
 */
public class Application {
	private final IWidgetFactory widgetFactory;

	public Application(IWidgetFactory widgetFactory) {
		this.widgetFactory = widgetFactory;
	}
	
	public IWidgetFactory getWidgetFactory() {
		return widgetFactory;
	}
	
	public void startGUI() {
		IButton btnOne = getWidgetFactory().createButton(); //utworzenie przycisku przy uzyciu fabryki abstrakcyjnej
		IButton btnTwo = getWidgetFactory().createButton();
		IEditField fieldCity = getWidgetFactory().createEditField();
		
		//wykorzystac stworzone przyciski i pole edycyjne
	}
}
