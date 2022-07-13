package ExercicioJUnitVanilla.application;

import ExercicioJUnitVanilla.entities.Financing;

public class Program {

	public static void main(String[] args) {

		try {
			Financing f1 = new Financing(100000.00, 2000.00, 20);
			System.out.println("Financiamento 2 no valor de: R$ " + f1.getTotalAmount());
			System.out.println("Renda do cliente: " + f1.getIncome());
			System.out.println("Quantidade de parcelas: " + f1.getMonths());
			System.out.println("Valor da entrada: " + f1.entry());
			System.out.println("Valor das parcelas: R$ " + f1.quota());
		} catch (IllegalArgumentException e) {
			System.out.println("Erro no Financiamento 1: " + e.getMessage());
		}
		
		System.out.println();
		
		try {
			Financing f2 = new Financing(100000.00, 2000.00, 80);
			System.out.println("Financiamento 2 no valor de: R$ " + f2.getTotalAmount());
			System.out.println("Renda do cliente: " + f2.getIncome());
			System.out.println("Quantidade de parcelas: " + f2.getMonths());
			System.out.println("Valor da entrada: " + f2.entry());
			System.out.println("Valor das parcelas: R$ " + f2.quota());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
