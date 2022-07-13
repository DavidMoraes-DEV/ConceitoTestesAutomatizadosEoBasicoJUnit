package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

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
		Account acc = AccountFactory.createEmptyAccount();
		
		//Act:
		acc.deposit(amount);
		
		//Assert: Se isso der verdadeiro a classe Account esta fazendo o dep�sito de acordo com as regras de decontar 2% por dep�sito
		Assertions.assertEquals(expectedValue, acc.getBalance()); //Biblioteca de declara��es
	}
	
	//Testa que o dep�sito n�o deve fazer nada se o valor final do dep�sito for negativo
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
	
	//Testa se o saque ir� diminuir o saldo se tiver saldo suficiente
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		
		Account acc = AccountFactory.createAccount(800.0);
		
		acc.withdraw(500.00);
		
		Assertions.assertEquals(300.0, acc.getBalance());
	}
	
	//Testa se o saque ir� gerar uma exce��o caso o saldo seja insuficiente para realizar o saque solicitado
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		
		//PECULIARIDADE para fazer um ASSERTIONS de exce��o "() -> {CONDI��O}"
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			
			acc.withdraw(801.00);
		});
	}
}
