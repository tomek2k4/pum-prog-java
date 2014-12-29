package Zadania;


public class Tab<E>{
	private static final int ROZMIAR_POCZATKOWY = 3;

	private static final double WSPOLCZYNNIK_WYPELNIENIA = 0.25;
	
	protected int dlugosc = 0;
	protected Object[] dane = new Object[ROZMIAR_POCZATKOWY];
	
	@SuppressWarnings("unchecked")
	public E get(int i){
		if (i<0 || i>=dlugosc) {
			throw new ArrayIndexOutOfBoundsException("Niepoprawny indeks.");
		}
		return (E)dane[i];
	}
	
	public void set(int i, E wartosc) {
		if (i<0 || i>=dlugosc){
			throw new ArrayIndexOutOfBoundsException("Niepoprawny indeks.");
		}
		dane[i] = wartosc;
	}
	
	public void add(E wartosc) {
		dlugosc++;
		if( dlugosc>dane.length )
		{
			zmienRozmiarTablicy(2*dane.length);
		}
		dane[dlugosc-1] = wartosc;
	}
	
	public E trim() {
		
		if(dlugosc>0){
			dlugosc--;
			@SuppressWarnings("unchecked")
			E ret = (E) dane[dlugosc];
			dane[dlugosc] = null;
			
			if((double)dlugosc <= dane.length*WSPOLCZYNNIK_WYPELNIENIA){
				zmienRozmiarTablicy(dane.length/2);
			}
			return ret;
		}
		return null;
	}

	private void zmienRozmiarTablicy(int rozm) {
		Object[] tmp = new Object[rozm];
	    for(int i=0;i<dane.length;i++){
	    	tmp[i] = dane[i];
	    }
	    dane = tmp;
	}
	
	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("{");
		
		for(int i=0;i<dlugosc;i++){
			if(i!=dlugosc-1){
				buffer.append(dane[i]+","); 
			}else{
				buffer.append(dane[i]);
			}
		}
		buffer.append("}");
		
		return buffer.toString();
	}
}
