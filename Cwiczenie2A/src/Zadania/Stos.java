package Zadania;

public class Stos {

	private Element top = null; 
		
	public void push(Object obj){
		Element e = new Element(obj,this.top);
		top = e;
	}
	
	public Object pop(){
		if(isEmpty()){
			return null;
		} else{
			Object retVal = top.dane;
			top = top.nastepny;
			return retVal;	
		}
		
	}
	
	public Object top(){
		
		if(isEmpty()){
			return null;
		} else{
			return top.dane;
		}
	}
	
	public boolean isEmpty() {
		return (top==null);
	}

}
