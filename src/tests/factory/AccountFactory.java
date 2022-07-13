package tests.factory;

import entities.Account;

//Fabrica de objetos Account
public class AccountFactory {
	
	//F�brica de cria��o de objetos que auxilia nos testes automatizados para n�o ter que ficar instanciando manualmente em todos os diferentes tipos de testes principalmente quando for v�rios atributos
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	//
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}