package Zadania;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Kolejka k = new Kolejka();
		k.enqueue("Hello,");
		k.enqueue("World");
		k.enqueue(" Tomek");

		System.out.println(k.last());
		System.out.println(k.dequeue());
	}

}
