package Zadania;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Ulamek a = new Ulamek(1,2);
//		Ulamek b = new Ulamek(1,2);
//		
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a.dodaj(b));
//		System.out.println(a.odejmij(b));
//		System.out.println(a.pomnoz(b));
//		System.out.println(a.podziel(b));
//		System.out.println(a.doubleValue());
//		System.out.println(a.equals(b));
		
//		Tab<Ulamek> t = new Tab<>();
//		
//		t.add(new Ulamek(1,2));
//		t.add(new Ulamek(2,3));
//		t.add(new Ulamek(5,7));
//		t.add(new Ulamek(5,7));
//		t.add(new Ulamek(5,7));
//		t.add(new Ulamek(5,7));
//		t.add(new Ulamek(1,7));
//		t.add(new Ulamek(2,7));
//		t.add(new Ulamek(3,7));
//		t.add(new Ulamek(4,7));
//		t.add(new Ulamek(5,7));
//		t.add(new Ulamek(3,4));
//		t.trim();
//		
//		System.out.println(t.trim());
//		System.out.println(t.trim());
		
		SortTab<Integer> t = new SortTab<>();
		t.add(123);
		t.add(10);
		t.add(5);
		t.add(2);
		t.add(4);
		t.add(8);
		t.add(1);
		System.out.println(t);
		t.trim();
		t.trim();
		System.out.println(t);
		
	}

}
