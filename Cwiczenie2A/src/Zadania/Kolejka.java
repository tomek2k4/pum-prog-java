package Zadania;

public class Kolejka {
	
	private int sumaElementow;
	private Element pierwszy = null;
    private Element ostatni = null; 

	public void enqueue(Object obj){
		Element obecny = ostatni;
		ostatni = new Element(obj, null);
		
        if (sumaElementow++ == 0) pierwszy = ostatni;
        else obecny.nastepny = ostatni;
	}
	
	public Object dequeue(){
        if (sumaElementow == 0) throw new java.util.NoSuchElementException();
        Object element = pierwszy.dane;
        pierwszy = pierwszy.nastepny;
        if (--sumaElementow == 0) ostatni = null;
        return element;
	}
	
	public Object last(){
		if (sumaElementow == 0) throw new java.util.NoSuchElementException();
		return ostatni.dane;
	}
	
	public boolean isEmpty(){
		if (sumaElementow == 0) return true;
		return false;
	}
	
	
}
