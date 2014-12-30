package Zadania;

 class Element {
	Object dane;
	Element nastepny = null;
	
	public Element(Object dane, Element nastepny) {
		this.dane = dane;
		this.nastepny = nastepny;
	}
	
}
