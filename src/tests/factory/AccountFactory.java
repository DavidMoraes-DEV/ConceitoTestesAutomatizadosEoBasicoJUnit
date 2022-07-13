package tests.factory;

import entities.Account;

//Fabrica de objetos Account
public class AccountFactory {
	
	//Fábrica de criação de objetos que auxilia nos testes automatizados para não ter que ficar instanciando manualmente em todos os diferentes tipos de testes principalmente quando for vários atributos
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	//
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}