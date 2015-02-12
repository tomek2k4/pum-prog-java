package edu.uj.javatop.ptrns.adapter;

public class Printer {

	public final static void printCarInformation(IUsaCar uc) {
		System.out.println(uc.getDescription() + "(" + uc.getGasPer100Miles() + ", " + uc.getMaxSpeedMileH() +" miles/h)");
	}
}
