package edu.uj.javatop.ptrns.adapter;

public class AdapterTest {

	public static void main(String[] args) {
		ICar autko = new FordFocus();
		Printer.printCarInformation(new EuropeCarAdapter(autko));		
	}
	
	private static class FordFocus implements ICar {
		@Override
		public double getGasPer100Km() {
			return 8.2;
		}		
		
		@Override
		public int getMaxSpeedKmH() {
			return 190;
		}
		@Override
		public String getModel() {
			return "Focus";
		}
		@Override
		public String getProducer() {
			return "Ford";
		}
	}

}
