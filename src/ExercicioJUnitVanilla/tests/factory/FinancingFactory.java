package ExercicioJUnitVanilla.tests.factory;

import ExercicioJUnitVanilla.entities.Financing;

public class FinancingFactory {
	
	public static Financing createFinancing() {
		return new Financing(100000.0, 2000.0, 80);
	}
	public static Financing createFinancing(Double income, Integer months) {
		return new Financing(100000.0, income, months);
	}
}
