package edu.uj.javatop.ptrns.adapter;

/**
 * Wzorzec Adapter
 * W tym przypadku klasa adaptera zmienia interface ICar tak by dzialal jak IUsaCar.
 *
 */
public class EuropeCarAdapter implements IUsaCar {
	
	private static final double MILE_TO_KM = 1.6;
	
	private final ICar car;

	public EuropeCarAdapter(ICar car) {
		super();
		this.car = car;
	}

	@Override
	public int getMaxSpeedMileH() {
		return (int) (car.getMaxSpeedKmH() / MILE_TO_KM);
	}

	@Override
	public double getGasPer100Miles() {
		return car.getGasPer100Km() * MILE_TO_KM;
	}

	@Override
	public String getDescription() {
		return car.getProducer() + " " + car.getModel();
	}

}
