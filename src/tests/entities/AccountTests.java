package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	//testa se realmente o m�todo deposit aumenta o saldo quando o valor for positivo
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() { //Nomenclatura padr�o: <A��O> Should <EFEITO> [When <CEN�RIO>](Opicional)
		/*
		 * Padr�o AAA
		  - Arrange: Instancie os objetos necess�rios
		  - Act: Execute as a��es necess�rias
		  - Assert: Declare o que deveria acontecer (Resultado esperando)
		*/
		
		//Arrange:
		double amount = 200.00;
		double expectedValue = 196.00;
		Account acc = new Account(1L, 0.0);
		
		//Act:
		acc.deposit(amount);
		
		//Assert: Se isso der verdadeiro a classe Account esta fazendo o dep�sito de acordo com as regras de decontar 2% por dep�sito
		Assertions.assertEquals(expectedValue, acc.getBalance()); //Biblioteca de declara��es
	}
}
