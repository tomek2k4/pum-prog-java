package edu.uj.javatop.ptrns.factory;

/**
 * Interfejs fabryki abstrakcyjnej.
 *
 */
public interface IWidgetFactory {
	IButton createButton();
	IEditField createEditField();
}
