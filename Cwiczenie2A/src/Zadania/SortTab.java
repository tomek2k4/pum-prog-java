package Zadania;

@SuppressWarnings("rawtypes")
public class SortTab<E extends Comparable> extends Tab<E> {
	
	@SuppressWarnings("unchecked")
	@Override
	public void add(E wartosc) {
		super.add(wartosc);
		int ix = dlugosc - 1;
		while( (ix-1 >= 0) && (wartosc.compareTo(dane[ix-1]) < 0)){
			dane[ix] = dane[ix-1];
			ix--;
		}
		dane[ix] = wartosc;
	}
	
	@Override
	public void set(int i, E wartosc) {
		super.set(i, wartosc);
	}
	
	public void set(E wartosc){
		add(wartosc);
	}

	
}
