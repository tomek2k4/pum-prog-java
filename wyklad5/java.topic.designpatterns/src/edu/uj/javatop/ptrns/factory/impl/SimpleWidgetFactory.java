package edu.uj.javatop.ptrns.factory.impl;

import edu.uj.javatop.ptrns.factory.IButton;
import edu.uj.javatop.ptrns.factory.IEditField;
import edu.uj.javatop.ptrns.factory.IWidgetFactory;

public class SimpleWidgetFactory implements IWidgetFactory {

	@Override
	public IButton createButton() {
		return new FunnyButton();
	}

	@Override
	public IEditField createEditField() {
		return new EnhancedTextField();
	}

}
