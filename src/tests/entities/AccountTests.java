package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	//testa se realmente o método deposit aumenta o saldo quando o valor for positivo
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() { //Nomenclatura padrão: <AÇÃO> Should <EFEITO> [When <CENÁRIO>](Opicional)
		/*
		 * Padrão AAA
		  - Arrange: Instancie os objetos necessários
		  - Act: Execute as ações necessárias
		  - Assert: Declare o que deveria acontecer (Resultado esperando)
		*/
		
		//Arrange:
		double amount = 200.00;
		double expectedValue = 196.00;
		Account acc = new Account(1L, 0.0);
		
		//Act:
		acc.deposit(amount);
		
		//Assert: Se isso der verdadeiro a classe Account esta fazendo o depósito de acordo com as regras de decontar 2% por depósito
		Assertions.assertEquals(expectedValue, acc.getBalance()); //Biblioteca de declaraçôes
	}
}
