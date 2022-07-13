package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

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
		Account acc = AccountFactory.createEmptyAccount();
		
		//Act:
		acc.deposit(amount);
		
		//Assert: Se isso der verdadeiro a classe Account esta fazendo o depósito de acordo com as regras de decontar 2% por depósito
		Assertions.assertEquals(expectedValue, acc.getBalance()); //Biblioteca de declaraçôes
	}
	
	//Testa que o depósito não deve fazer nada se o valor final do depósito for negativo
	@Test
	public void depositShouldDoNothingNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	//Testa se a retirada total deve liberar o saldo e retornar o saldo total = 0.0
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		
		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullWithdraw();
		
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}
	
	//Testa se o saque irá diminuir o saldo se tiver saldo suficiente
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.00);
		
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	//Testa se o saque irá gerar uma exceção caso o saldo seja insuficiente para realizar o saque solicitado
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		//PECULIARIDADE para fazer um ASSERTIONS de exceção "() -> {CONDIÇÃO}"
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			
			acc.withdraw(801.00);
		});
	}
}
